package com.tech.labs.ServiceModule.Dto;

import com.tech.labs.DaoModule.Entities.Owners;
import com.tech.labs.DaoModule.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private List<Role> roles;
    private Owners owner;

}
