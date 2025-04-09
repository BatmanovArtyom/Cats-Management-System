package com.tech.labs.ServiceModule.ServiceInterface;

import com.tech.labs.ServiceModule.Dto.ColorDto;

import java.util.List;

public interface ColorsService {
    void saveOrUpdateColorTable(ColorDto colorDto);
    List<ColorDto> getAllColors();
    ColorDto getColorById(Long id);
    void addColor(ColorDto colorDto);
    void deleteColor(ColorDto colorDto);
}
