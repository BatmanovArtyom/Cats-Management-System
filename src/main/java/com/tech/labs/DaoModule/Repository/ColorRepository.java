package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Colors, Long> {
}
