package com.tech.labs.ServiceModule.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatsFriendsDto {
    private Long id;
    private Long catID;
    private Long friendID;
}

