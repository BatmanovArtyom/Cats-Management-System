package com.tech.labs.ServiceModule.Mapping;

import com.tech.labs.DaoModule.Entities.Colors;
import com.tech.labs.ServiceModule.Dto.ColorDto;
import org.springframework.stereotype.Component;

@Component
public class ColorsMapping {
    public Colors fromDto(ColorDto colorDto){
        return new Colors(colorDto.getColorID(), colorDto.getColorName());
    }

    public ColorDto toDto(Colors colors){
        return new ColorDto(colors.getColorID(), colors.getColorName());
    }
}
