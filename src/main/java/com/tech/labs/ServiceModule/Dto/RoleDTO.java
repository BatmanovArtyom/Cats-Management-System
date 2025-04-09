package com.tech.labs.ServiceModule.Dto;

import com.tech.labs.DaoModule.Entities.Role;
import com.tech.labs.DaoModule.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO extends Role {
    private Long id;
    private String name;
    private List<User> users;
}
