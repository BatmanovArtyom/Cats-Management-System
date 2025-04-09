package com.tech.labs.ServiceModule.Implementation;

import com.tech.labs.DaoModule.Entities.Owners;
import com.tech.labs.DaoModule.Repository.OwnersRepository;
import com.tech.labs.ServiceModule.Dto.OwnersDto;
import com.tech.labs.ServiceModule.Mapping.OwnerMapping;
import com.tech.labs.ServiceModule.ServiceInterface.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OwnersServiceImpl implements OwnersService {

    private final OwnersRepository ownersRepository;
    private final OwnerMapping ownerMapping;

    @Override
    public OwnersDto saveOrUpdateOwnerTable(OwnersDto ownerDto) {
        Owners newOwners = ownerMapping.fromDto(ownerDto);
        ownersRepository.save(newOwners);
        return ownerDto;
    }

    @Override
    public List<OwnersDto> getAllOwners() {
        List<Owners> ownersList = ownersRepository.findAll();
        return ownersList.stream().map(ownerMapping::toDto).collect(Collectors.toList());
    }

    @Override
    public OwnersDto getOwnerById(Long id){
        Owners owner = ownersRepository.findById(id).orElse(null);
        if (owner != null) {
            return ownerMapping.toDto(owner);
        }
        return null;
    }

    @Override
    public OwnersDto addOwner(OwnersDto ownerDto) {
        Owners newOwner = ownerMapping.fromDto(ownerDto);
        ownersRepository.save(newOwner);
        return ownerDto;
    }

    @Override
    public void deleteOwner(OwnersDto ownerDto) {
        Owners ownerToDelete = ownerMapping.fromDto(ownerDto);
        ownersRepository.delete(ownerToDelete);
    }
}