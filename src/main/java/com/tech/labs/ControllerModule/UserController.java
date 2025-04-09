package com.tech.labs.ControllerModule;

import com.tech.labs.ServiceModule.Dto.UserDTO;
import com.tech.labs.ServiceModule.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDTO create(@RequestBody UserDTO userDTO){
        return userService.add(userDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) throws ParseException {
        userService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    @ResponseBody
    public List<UserDTO> getAll() {
        return userService.getAll();
    }
}
