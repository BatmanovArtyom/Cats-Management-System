package com.tech.labs.DaoModule.Repository;

import com.tech.labs.DaoModule.Entities.CatsFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatsFriendsRepository extends JpaRepository<CatsFriends,Long> {
    CatsFriends findByCatIDAndFriendID(Long catID, Long friendID);
}
