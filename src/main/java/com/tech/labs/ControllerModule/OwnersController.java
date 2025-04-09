package com.tech.labs.ControllerModule;

import com.tech.labs.DaoModule.Entities.User;
import com.tech.labs.ServiceModule.Dto.OwnersDto;
import com.tech.labs.ServiceModule.Dto.RoleDTO;
import com.tech.labs.ServiceModule.Implementation.UserServiceImpl;
import com.tech.labs.ServiceModule.ServiceInterface.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/owners")
public class OwnersController {

    private final OwnersService ownersService;
    private final UserServiceImpl userService;

    @Autowired
    public OwnersController(OwnersService ownersService, UserServiceImpl userService) {
        this.ownersService = ownersService;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN') or isAuthenticated()")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OwnersDto create(@RequestBody OwnersDto ownerDTO) {
        User user = userService.getCurrentUser();
        RoleDTO role = new RoleDTO();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        if (!(Objects.equals(user.getOwner().getOwnerID(), ownerDTO.getOwnerID())) ||
                user.getRoles().contains(role)) {
            return null;
        }
        return ownersService.addOwner(ownerDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    @ResponseBody
    public List<OwnersDto> getAll() {
        return ownersService.getAllOwners();
    }

    @PreAuthorize("hasRole('ADMIN') or isAuthenticated()")
    @GetMapping("/{id}")
    @ResponseBody
    public OwnersDto getById(@PathVariable int id) {
        return ownersService.getOwnerById((long) id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) throws ParseException {
        User user = userService.getCurrentUser();
        RoleDTO role = new RoleDTO();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        if ((!(Objects.equals(user.getOwner().getOwnerID(), id) ||
                user.getRoles().contains(role)))) {
            return;
        }
        ownersService.getOwnerById((long) id);
    }

    @PreAuthorize("hasRole('ADMIN') or isAuthenticated()")
    @PostMapping("/{id}")
    @ResponseBody
    public OwnersDto update(@RequestBody OwnersDto ownerDTO, @PathVariable int id) throws ParseException {
        User user = userService.getCurrentUser();
        RoleDTO role = new RoleDTO();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        if ((!(Objects.equals(user.getOwner().getOwnerID(), id) ||
                user.getRoles().contains(role)))) {
            return null;
        }
        return ownersService.saveOrUpdateOwnerTable(ownerDTO);
    }
}
