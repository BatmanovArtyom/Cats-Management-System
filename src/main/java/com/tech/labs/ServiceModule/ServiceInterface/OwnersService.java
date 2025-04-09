package com.tech.labs.ServiceModule.ServiceInterface;

import com.tech.labs.ServiceModule.Dto.OwnersDto;

import java.util.List;

public interface OwnersService {
    OwnersDto saveOrUpdateOwnerTable(OwnersDto ownerDto);
    List<OwnersDto> getAllOwners();
    OwnersDto getOwnerById(Long id);
    OwnersDto addOwner(OwnersDto ownerDto);
    void deleteOwner(OwnersDto ownerDto);
}
