package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Roadmap;
import com.newcampvex.newcampvex.services.RoadmapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roadmaps")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoadmapController {
    private final RoadmapService roadmapService;

    @PostMapping
    public ResponseEntity<Roadmap> createRoadmap(@RequestBody Roadmap roadmap) {
        try {
            Roadmap createdRoadmap = roadmapService.createRoadmap(roadmap);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRoadmap);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roadmap> getRoadmap(@PathVariable String id) {
        Optional<Roadmap> roadmap = roadmapService.getRoadmap(id);
        return roadmap.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roadmap> updateRoadmap(@PathVariable String id, @RequestBody Roadmap roadmap) {
        try {
            Roadmap updatedRoadmap = roadmapService.updateRoadmap(id, roadmap);
            return ResponseEntity.ok(updatedRoadmap);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoadmap(@PathVariable String id) {
        try {
            roadmapService.deleteRoadmap(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Roadmap>> getAllRoadmaps() {
        List<Roadmap> roadmaps = roadmapService.getAllRoadmaps();
        return ResponseEntity.ok(roadmaps);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Roadmap>> getRoadmapsByCategory(@PathVariable String category) {
        List<Roadmap> roadmaps = roadmapService.getRoadmapsByCategory(category);
        return ResponseEntity.ok(roadmaps);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Roadmap>> getRoadmapsByDifficulty(@PathVariable String difficulty) {
        List<Roadmap> roadmaps = roadmapService.getRoadmapsByDifficulty(difficulty);
        return ResponseEntity.ok(roadmaps);
    }
}
