package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
