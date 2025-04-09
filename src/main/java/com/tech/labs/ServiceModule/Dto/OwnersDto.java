package com.tech.labs.ServiceModule.Dto;

import com.tech.labs.DaoModule.Entities.Cats;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OwnersDto {
    private Long ownerID;
    private String ownerName;
    private String ownerBirthdate;
    private List<Cats> listCats;

}