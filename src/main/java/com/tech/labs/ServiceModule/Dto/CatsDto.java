package com.tech.labs.ServiceModule.Dto;

import com.tech.labs.DaoModule.Entities.Breeds;
import com.tech.labs.DaoModule.Entities.Colors;
import com.tech.labs.DaoModule.Entities.Owners;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatsDto {
    private Long CatID;
    private String catName;
    private LocalDate сatBirthdate;
    private Owners owner;
    private Breeds breed;
    private Colors color;
}