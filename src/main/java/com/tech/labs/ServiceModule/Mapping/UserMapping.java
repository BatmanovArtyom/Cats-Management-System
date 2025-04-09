package com.tech.labs.ServiceModule.Mapping;

import com.tech.labs.DaoModule.Entities.User;
import com.tech.labs.ServiceModule.Dto.UserDTO;
import org.springframework.stereotype.Component;


@Component
public class UserMapping {
    public User fromDto(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getLogin(), userDTO.getPassword(), userDTO.getRoles(), userDTO.getOwner());
    }

    public UserDTO toDto(User user){
        return new UserDTO(user.getId(), user.getLogin(), user.getPassword(), user.getRoles(), user.getOwner());
    }

}
