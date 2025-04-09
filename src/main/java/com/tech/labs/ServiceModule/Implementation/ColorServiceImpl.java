package com.tech.labs.ServiceModule.Implementation;

import com.tech.labs.DaoModule.Entities.Colors;
import com.tech.labs.DaoModule.Repository.ColorRepository;
import com.tech.labs.ServiceModule.Dto.ColorDto;
import com.tech.labs.ServiceModule.Mapping.ColorsMapping;
import com.tech.labs.ServiceModule.ServiceInterface.ColorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ColorServiceImpl implements ColorsService {

    private final ColorRepository colorRepository;
    private final ColorsMapping colorsMapping;

    @Override
    public void saveOrUpdateColorTable(ColorDto colorDto) {
        Colors newColors = colorsMapping.fromDto(colorDto);
        colorRepository.save(newColors);

    }

    @Override
    public List<ColorDto> getAllColors() {
        List<Colors> colorsList = colorRepository.findAll();
        return colorsList.stream().map(colorsMapping::toDto).collect(Collectors.toList());
    }

    @Override
    public ColorDto getColorById(Long id) {
        Colors colors = colorRepository.findById(id).orElse(null);
        if(colors != null){
            return colorsMapping.toDto(colors);
        }
        return null;
    }

    @Override
    public void addColor(ColorDto colorDto) {
        Colors newColors = colorsMapping.fromDto(colorDto);
        colorRepository.save(newColors);
    }

    @Override
    public void deleteColor(ColorDto colorDto) {
        Colors colorsToDelete = colorsMapping.fromDto(colorDto);
        colorRepository.delete(colorsToDelete);
    }
}