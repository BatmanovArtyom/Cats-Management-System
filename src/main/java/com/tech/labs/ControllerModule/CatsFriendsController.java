package com.tech.labs.ControllerModule;

import com.tech.labs.ServiceModule.Dto.CatsFriendsDto;
import com.tech.labs.ServiceModule.Implementation.CatsFriendsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cats-friends")
public class CatsFriendsController {

    private final CatsFriendsServiceImpl catsFriendsService;

    @Autowired
    public CatsFriendsController(CatsFriendsServiceImpl catsFriendsService) {
        this.catsFriendsService = catsFriendsService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<String> addFriendForCat(@RequestBody CatsFriendsDto catsFriendsDto) {
        catsFriendsService.saveOrUpdateCatsFriendsTable(catsFriendsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cat friend added successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCatFriend(@RequestBody CatsFriendsDto catsFriendsDto) {
        catsFriendsService.deleteCatFriend(catsFriendsDto);
        return ResponseEntity.ok("Cat friend deleted successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{catID}/friend/{friendID}")
    public ResponseEntity<CatsFriendsDto> getCatFriendById(
            @PathVariable Long catID,
            @PathVariable Long friendID
    ) {
        CatsFriendsDto catFriendDto = catsFriendsService.getCatFriendById(catID, friendID);
        if (catFriendDto != null) {
            return ResponseEntity.ok(catFriendDto);
        }
        return ResponseEntity.notFound().build();
    }
}