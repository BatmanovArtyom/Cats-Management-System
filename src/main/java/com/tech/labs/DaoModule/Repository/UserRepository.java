package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.login = :login")
    Optional<User> findByLoginWithRoles(String login);
}
