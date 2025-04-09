package com.tech.labs.ServiceModule.Implementation;

import com.tech.labs.DaoModule.Entities.CatsFriends;
import com.tech.labs.DaoModule.Repository.CatsFriendsRepository;
import com.tech.labs.ServiceModule.Dto.CatsFriendsDto;
import com.tech.labs.ServiceModule.Mapping.CatsFriendsMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CatsFriendsServiceImpl {
    private final CatsFriendsRepository catsFriendsRepository;
    private final CatsFriendsMapping catsFriendsMapping;

    public void saveOrUpdateCatsFriendsTable(CatsFriendsDto catsFriendsDto) {
        CatsFriends newCatsFriends = catsFriendsMapping.fromDto(catsFriendsDto);
        catsFriendsRepository.save(newCatsFriends);
    }

    public void deleteCatFriend(CatsFriendsDto catsFriendsDto) {
        CatsFriends catsFriendsToDelete = catsFriendsMapping.fromDto(catsFriendsDto);
        catsFriendsRepository.delete(catsFriendsToDelete);
    }

    public CatsFriendsDto getCatFriendById(Long catID, Long friendID) {
        CatsFriends catsFriends = catsFriendsRepository.findByCatIDAndFriendID(catID, friendID);
        if (catsFriends != null) {
            return catsFriendsMapping.toDto(catsFriends);
        }
        return null;
    }
}
