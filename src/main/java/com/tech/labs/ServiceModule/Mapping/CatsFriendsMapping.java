package com.tech.labs.ServiceModule.Mapping;

import com.tech.labs.DaoModule.Entities.CatsFriends;
import com.tech.labs.ServiceModule.Dto.CatsFriendsDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CatsFriendsMapping {
    public CatsFriends fromDto(CatsFriendsDto catsFriendsDto){
        return new CatsFriends(catsFriendsDto.getId(), catsFriendsDto.getCatID(), catsFriendsDto.getFriendID());
    }

    public CatsFriendsDto toDto(CatsFriends catsFriends){
        return new CatsFriendsDto(catsFriends.getId(), catsFriends.getCatID(), catsFriends.getFriendID());
    }
}