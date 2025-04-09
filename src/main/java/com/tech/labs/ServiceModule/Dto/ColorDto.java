package com.tech.labs.ServiceModule.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ColorDto {
    private Long colorID;
    private String colorName;
}