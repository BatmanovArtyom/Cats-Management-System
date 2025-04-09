package com.tech.labs.ServiceModule.Implementation;

import com.tech.labs.DaoModule.Entities.Breeds;
import com.tech.labs.DaoModule.Repository.BreedsRepository;
import com.tech.labs.ServiceModule.Dto.BreedsDto;
import com.tech.labs.ServiceModule.Mapping.BreedsMapping;
import com.tech.labs.ServiceModule.ServiceInterface.BreedsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BreedsServiceImpl implements BreedsService {
    private final BreedsRepository breedsRepository;
    private final BreedsMapping breedsMapping;

    @Override
    public void saveOrUpdateBreedTable(BreedsDto breedsDto) {
        Breeds newBreeds = breedsMapping.fromDto(breedsDto);
        breedsRepository.save(newBreeds);
    }

    @Override
    public List<BreedsDto> getAllBreeds() {
        List<Breeds> breedsList = breedsRepository.findAll();
        return breedsList.stream().map(breedsMapping::toDto).collect(Collectors.toList());
    }

    @Override
    public BreedsDto getBreedById(Long id) {
        Breeds breed = breedsRepository.findById(id).orElse(null);
        if (breed != null){
            return breedsMapping.toDto(breed);
        }
        return null;
    }

    @Override
    public void addBreed(BreedsDto breedDto) {
        Breeds newBreeds = breedsMapping.fromDto(breedDto);
        breedsRepository.save(newBreeds);
    }

    @Override
    public void deleteBreed(BreedsDto breedDto) {
        Breeds breedToDelete = breedsMapping.fromDto(breedDto);
        breedsRepository.delete(breedToDelete);
    }
}
