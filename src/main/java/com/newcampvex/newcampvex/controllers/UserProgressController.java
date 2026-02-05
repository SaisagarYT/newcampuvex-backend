package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.UserProgress;
import com.newcampvex.newcampvex.services.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-progress")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserProgressController {
    private final UserProgressService userProgressService;

    @PostMapping
    public ResponseEntity<UserProgress> createProgress(@RequestBody UserProgress progress) {
        try {
            UserProgress createdProgress = userProgressService.createProgress(progress);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProgress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProgress> getProgress(@PathVariable String id) {
        Optional<UserProgress> progress = userProgressService.getProgress(id);
        return progress.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProgress> updateProgress(@PathVariable String id, @RequestBody UserProgress progress) {
        try {
            UserProgress updatedProgress = userProgressService.updateProgress(id, progress);
            return ResponseEntity.ok(updatedProgress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgress(@PathVariable String id) {
        try {
            userProgressService.deleteProgress(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserProgress>> getUserProgress(@PathVariable String userId) {
        List<UserProgress> progress = userProgressService.getUserProgress(userId);
        return ResponseEntity.ok(progress);
    }

    @GetMapping("/user/{userId}/status/{status}")
    public ResponseEntity<List<UserProgress>> getUserProgressByStatus(
            @PathVariable String userId, 
            @PathVariable String status) {
        List<UserProgress> progress = userProgressService.getUserProgressByStatus(userId, status);
        return ResponseEntity.ok(progress);
    }

    @GetMapping("/user/{userId}/problem/{problemId}")
    public ResponseEntity<UserProgress> getProgressByUserAndProblem(
            @PathVariable String userId,
            @PathVariable String problemId) {
        Optional<UserProgress> progress = userProgressService.getProgressByUserAndProblem(userId, problemId);
        return progress.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
