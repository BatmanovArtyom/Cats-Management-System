package com.tech.labs.ServiceModule.Mapping;

import com.tech.labs.DaoModule.Entities.Owners;
import com.tech.labs.ServiceModule.Dto.OwnersDto;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapping {
    public Owners fromDto(OwnersDto ownersDto){
        return new Owners(ownersDto.getOwnerID(), ownersDto.getOwnerName(),ownersDto.getOwnerBirthdate(),ownersDto.getListCats());
    }

    public OwnersDto toDto(Owners owners){
        return new OwnersDto(owners.getOwnerID(), owners.getOwnerName(), owners.getOwnerBirthdate(), owners.getListCats());
    }
}
