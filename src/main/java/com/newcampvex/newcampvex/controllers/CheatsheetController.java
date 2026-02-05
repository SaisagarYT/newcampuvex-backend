package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Cheatsheet;
import com.newcampvex.newcampvex.services.CheatsheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cheatsheets")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CheatsheetController {
    private final CheatsheetService cheatsheetService;

    @PostMapping
    public ResponseEntity<Cheatsheet> createCheatsheet(@RequestBody Cheatsheet cheatsheet) {
        try {
            Cheatsheet createdCheatsheet = cheatsheetService.createCheatsheet(cheatsheet);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCheatsheet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cheatsheet> getCheatsheet(@PathVariable String id) {
        Optional<Cheatsheet> cheatsheet = cheatsheetService.getCheatsheet(id);
        return cheatsheet.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cheatsheet> updateCheatsheet(@PathVariable String id, @RequestBody Cheatsheet cheatsheet) {
        try {
            Cheatsheet updatedCheatsheet = cheatsheetService.updateCheatsheet(id, cheatsheet);
            return ResponseEntity.ok(updatedCheatsheet);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCheatsheet(@PathVariable String id) {
        try {
            cheatsheetService.deleteCheatsheet(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cheatsheet>> getAllCheatsheets() {
        List<Cheatsheet> cheatsheets = cheatsheetService.getAllCheatsheets();
        return ResponseEntity.ok(cheatsheets);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Cheatsheet>> getCheatsheetsByCategory(@PathVariable String category) {
        List<Cheatsheet> cheatsheets = cheatsheetService.getCheatsheetsByCategory(category);
        return ResponseEntity.ok(cheatsheets);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Cheatsheet>> getCheatsheetsByDifficulty(@PathVariable String difficulty) {
        List<Cheatsheet> cheatsheets = cheatsheetService.getCheatsheetsByDifficulty(difficulty);
        return ResponseEntity.ok(cheatsheets);
    }
}
