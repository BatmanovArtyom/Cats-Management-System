package com.tech.labs.ServiceModule.Mapping;

import com.tech.labs.DaoModule.Entities.Breeds;
import com.tech.labs.ServiceModule.Dto.BreedsDto;
import org.springframework.stereotype.Component;

@Component
public class BreedsMapping {
    public Breeds fromDto(BreedsDto breedsDto){
        return new Breeds(breedsDto.getBreedID(), breedsDto.getBreedName());
    }

    public BreedsDto toDto(Breeds breeds){
        return new BreedsDto(breeds.getBreedID(), breeds.getBreedName());
    }
}
