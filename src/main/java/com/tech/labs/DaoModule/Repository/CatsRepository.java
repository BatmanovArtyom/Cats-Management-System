package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatsRepository extends JpaRepository<Cats, Long> {
}
