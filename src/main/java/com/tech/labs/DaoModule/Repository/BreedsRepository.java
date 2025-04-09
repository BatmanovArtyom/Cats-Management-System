package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.Breeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedsRepository extends JpaRepository<Breeds,Long> {
}
