package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.UserStats;
import com.newcampvex.newcampvex.services.UserStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user-stats")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserStatsController {
    private final UserStatsService userStatsService;

    @PostMapping
    public ResponseEntity<UserStats> createStats(@RequestBody UserStats stats) {
        try {
            UserStats createdStats = userStatsService.createStats(stats);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserStats> getStats(@PathVariable String id) {
        Optional<UserStats> stats = userStatsService.getStats(id);
        return stats.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserStats> getStatsByUserId(@PathVariable String userId) {
        Optional<UserStats> stats = userStatsService.getStatsByUserId(userId);
        return stats.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserStats> updateStats(@PathVariable String id, @RequestBody UserStats stats) {
        try {
            UserStats updatedStats = userStatsService.updateStats(id, stats);
            return ResponseEntity.ok(updatedStats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStats(@PathVariable String id) {
        try {
            userStatsService.deleteStats(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/{userId}/add-xp")
    public ResponseEntity<UserStats> addXP(@PathVariable String userId, @RequestParam Long xp) {
        try {
            UserStats stats = userStatsService.addXP(userId, xp);
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/{userId}/increment-problems-solved")
    public ResponseEntity<UserStats> incrementProblemsSolved(@PathVariable String userId) {
        try {
            UserStats stats = userStatsService.incrementProblemsSolved(userId);
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/{userId}/update-streak")
    public ResponseEntity<UserStats> updateStreak(@PathVariable String userId) {
        try {
            UserStats stats = userStatsService.updateStreak(userId);
            return ResponseEntity.ok(stats);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
