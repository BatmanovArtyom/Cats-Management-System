package com.tech.labs.ControllerModule;

import com.tech.labs.ServiceModule.Dto.ColorDto;
import com.tech.labs.ServiceModule.ServiceInterface.ColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colors")
public class ColorsController {

    private final ColorsService colorsService;

    @Autowired
    public ColorsController(ColorsService colorsService) {
        this.colorsService = colorsService;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/add")
    public ResponseEntity<String> addColor(@RequestBody ColorDto colorDto) {
        colorsService.saveOrUpdateColorTable(colorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Color added successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<ColorDto>> getAllColors() {
        List<ColorDto> colorsList = colorsService.getAllColors();
        return ResponseEntity.ok(colorsList);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ColorDto> getColorById(@PathVariable Long id) {
        ColorDto colorDto = colorsService.getColorById(id);
        if (colorDto != null) {
            return ResponseEntity.ok(colorDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteColor(@PathVariable Long id) {
        ColorDto colorDto = colorsService.getColorById(id);
        if (colorDto != null) {
            colorsService.deleteColor(colorDto);
            return ResponseEntity.ok("Color with ID " + id + " deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}