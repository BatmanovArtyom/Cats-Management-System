package com.tech.labs.ServiceModule.Mapping;


import com.tech.labs.DaoModule.Entities.Role;
import com.tech.labs.ServiceModule.Dto.RoleDTO;
import org.springframework.stereotype.Component;

@Component
public class RoleMapping {
    public Role fromDto(RoleDTO roleDTO){
        return new Role(roleDTO.getId(), roleDTO.getName(), roleDTO.getUsers());
    }

    public RoleDTO toDto(Role role){
        return new RoleDTO(role.getId(), role.getName(), role.getUsers());
    }
}
