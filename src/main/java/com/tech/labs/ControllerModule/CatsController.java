package com.tech.labs.ControllerModule;

import com.tech.labs.DaoModule.Entities.User;
import com.tech.labs.ServiceModule.Dto.CatsDto;
import com.tech.labs.ServiceModule.Implementation.UserServiceImpl;
import com.tech.labs.ServiceModule.ServiceInterface.CatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cats")
public class CatsController {

    private final CatsService catsService;
    private final UserServiceImpl userService;

    @Autowired
    public CatsController(CatsService catsService, UserServiceImpl userService) {
        this.catsService = catsService;
        this.userService = userService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<CatsDto> create(@RequestBody CatsDto catDTO) {
        User user = userService.getCurrentUser();
        if (!Objects.equals(user.getOwner().getOwnerID(), catDTO.getOwner())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        CatsDto createdCat = catsService.addCat(catDTO);
        return ResponseEntity.ok(createdCat);
    }

    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isCatOwner(principal, #catsDto.id)")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCat(@RequestBody CatsDto catsDto) {
        catsService.deleteCat(catsDto);
        return ResponseEntity.ok("Cat deleted successfully");
    }

    @PreAuthorize("hasRole('ADMIN') or @userSecurity.isCatOwner(principal, #id)")
    @GetMapping("/{id}")
    public ResponseEntity<CatsDto> getCatById(@PathVariable Long id) {
        CatsDto catDto = catsService.getCatById(id);
        if (catDto != null) {
            return ResponseEntity.ok(catDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<CatsDto>> getAllCats() {
        List<CatsDto> catsDtoList = catsService.getAllCats();
        if (!catsDtoList.isEmpty()) {
            return ResponseEntity.ok(catsDtoList);
        }
        return ResponseEntity.notFound().build();
    }
}
