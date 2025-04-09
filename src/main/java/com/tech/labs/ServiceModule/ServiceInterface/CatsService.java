package com.tech.labs.ServiceModule.ServiceInterface;

import com.tech.labs.ServiceModule.Dto.CatsDto;

import java.util.List;

public interface CatsService {
    void saveOrUpdateCatTable(CatsDto catsDto);
    List<CatsDto> getAllCats();
    CatsDto getCatById(Long id);
    CatsDto addCat(CatsDto catDto);
    void deleteCat(CatsDto catDto);
}
