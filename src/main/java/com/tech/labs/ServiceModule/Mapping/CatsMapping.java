package com.tech.labs.ServiceModule.Mapping;

import com.tech.labs.DaoModule.Entities.Cats;
import com.tech.labs.ServiceModule.Dto.CatsDto;
import org.springframework.stereotype.Component;

@Component
public class CatsMapping {
    public Cats fromDto(CatsDto catsDto){
        return new Cats(catsDto.getCatID(), catsDto.getCatName(), catsDto.getСatBirthdate(), catsDto.getOwner(), catsDto.getBreed(), catsDto.getColor());
    }

    public CatsDto toDto(Cats cats){
        return new CatsDto(cats.getCatID(), cats.getCatName(), cats.getСatBirthdate(), cats.getOwner(), cats.getBreed(), cats.getColor());
    }
}