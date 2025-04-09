package com.tech.labs.ServiceModule.ServiceInterface;

import com.tech.labs.ServiceModule.Dto.BreedsDto;

import java.util.List;

public interface BreedsService {
    void saveOrUpdateBreedTable(BreedsDto breedsDto);
    List<BreedsDto> getAllBreeds();
    BreedsDto getBreedById(Long id);
    void addBreed(BreedsDto breedDto);
    void deleteBreed(BreedsDto breedDto);
}
