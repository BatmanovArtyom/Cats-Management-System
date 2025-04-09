package com.tech.labs.ControllerModule;

import com.tech.labs.ServiceModule.Dto.BreedsDto;
import com.tech.labs.ServiceModule.ServiceInterface.BreedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breeds")
public class BreedsController {

    private final BreedsService breedsService;

    @Autowired
    public BreedsController(BreedsService breedsService) {
        this.breedsService = breedsService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public ResponseEntity<String> addBreed(@RequestBody BreedsDto breedsDto) {
        breedsService.saveOrUpdateBreedTable(breedsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Breed added successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBreed(@RequestBody BreedsDto breedsDto) {
        breedsService.deleteBreed(breedsDto);
        return ResponseEntity.ok("Breed deleted successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<BreedsDto> getBreedById(@PathVariable Long id) {
        BreedsDto breedDto = breedsService.getBreedById(id);
        if (breedDto != null) {
            return ResponseEntity.ok(breedDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<BreedsDto>> getAllBreeds() {
        List<BreedsDto> breedsDtoList = breedsService.getAllBreeds();
        if (!breedsDtoList.isEmpty()) {
            return ResponseEntity.ok(breedsDtoList);
        }
        return ResponseEntity.notFound().build();
    }
}
