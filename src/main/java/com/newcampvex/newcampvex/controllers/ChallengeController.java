package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Challenge;
import com.newcampvex.newcampvex.services.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/challenges")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChallengeController {
    private final ChallengeService challengeService;

    @PostMapping
    public ResponseEntity<Challenge> createChallenge(@RequestBody Challenge challenge) {
        try {
            Challenge createdChallenge = challengeService.createChallenge(challenge);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdChallenge);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String id) {
        Optional<Challenge> challenge = challengeService.getChallenge(id);
        return challenge.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Challenge> updateChallenge(@PathVariable String id, @RequestBody Challenge challenge) {
        try {
            Challenge updatedChallenge = challengeService.updateChallenge(id, challenge);
            return ResponseEntity.ok(updatedChallenge);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChallenge(@PathVariable String id) {
        try {
            challengeService.deleteChallenge(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        List<Challenge> challenges = challengeService.getAllChallenges();
        return ResponseEntity.ok(challenges);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Challenge>> getChallengesByStatus(@PathVariable String status) {
        List<Challenge> challenges = challengeService.getChallengesByStatus(status);
        return ResponseEntity.ok(challenges);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Challenge>> getChallengesByDifficulty(@PathVariable String difficulty) {
        List<Challenge> challenges = challengeService.getChallengesByDifficulty(difficulty);
        return ResponseEntity.ok(challenges);
    }
}
