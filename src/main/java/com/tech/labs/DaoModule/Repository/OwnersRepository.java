package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository extends JpaRepository<Owners, Long > {
}
