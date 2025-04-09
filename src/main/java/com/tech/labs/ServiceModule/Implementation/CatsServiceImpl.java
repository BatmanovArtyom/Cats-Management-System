package com.tech.labs.ServiceModule.Implementation;

import com.tech.labs.DaoModule.Entities.Cats;
import com.tech.labs.DaoModule.Repository.CatsRepository;
import com.tech.labs.ServiceModule.Dto.CatsDto;
import com.tech.labs.ServiceModule.Mapping.CatsMapping;
import com.tech.labs.ServiceModule.ServiceInterface.CatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CatsServiceImpl implements CatsService {

    private final CatsRepository catsRepository;
    private final CatsMapping catsMapping;

    @Override
    public void saveOrUpdateCatTable(CatsDto catsDto) {
        Cats newCats = catsMapping.fromDto(catsDto);
        catsRepository.save(newCats);
    }

    @Override
    public List<CatsDto> getAllCats() {
        List<Cats> catsList = catsRepository.findAll();
        return catsList.stream().map(catsMapping::toDto).collect(Collectors.toList());
    }

    @Override
    public CatsDto getCatById(Long id) {
        Cats cats = catsRepository.findById(id).orElse(null);
        if(cats != null){
            return catsMapping.toDto(cats);
        }
        return null;
    }

    @Override
    public CatsDto addCat(CatsDto catDto) {
        Cats newCat = catsMapping.fromDto(catDto);
        catsRepository.save(newCat);
        return catDto;
    }

    @Override
    public void deleteCat(CatsDto catDto) {
        Cats catToDelete = catsMapping.fromDto(catDto);
        catsRepository.delete(catToDelete);
    }
}