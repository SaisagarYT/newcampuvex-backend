package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Problem;
import com.newcampvex.newcampvex.services.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/problems")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProblemController {
    private final ProblemService problemService;

    @PostMapping
    public ResponseEntity<Problem> createProblem(@RequestBody Problem problem) {
        try {
            Problem createdProblem = problemService.createProblem(problem);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProblem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Problem> getProblem(@PathVariable String id) {
        Optional<Problem> problem = problemService.getProblem(id);
        return problem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Problem> updateProblem(@PathVariable String id, @RequestBody Problem problem) {
        try {
            Problem updatedProblem = problemService.updateProblem(id, problem);
            return ResponseEntity.ok(updatedProblem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProblem(@PathVariable String id) {
        try {
            problemService.deleteProblem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Problem>> getAllProblems() {
        List<Problem> problems = problemService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Problem>> getProblemsByCategory(@PathVariable String category) {
        List<Problem> problems = problemService.getProblemsByCategory(category);
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Problem>> getProblemsByDifficulty(@PathVariable String difficulty) {
        List<Problem> problems = problemService.getProblemsByDifficulty(difficulty);
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/platform/{platform}")
    public ResponseEntity<List<Problem>> getProblemsByPlatform(@PathVariable String platform) {
        List<Problem> problems = problemService.getProblemsByPlatform(platform);
        return ResponseEntity.ok(problems);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Problem>> getProblemsByCategoryAndDifficulty(
            @RequestParam String category, 
            @RequestParam String difficulty) {
        List<Problem> problems = problemService.getProblemsByCategoryAndDifficulty(category, difficulty);
        return ResponseEntity.ok(problems);
    }
}
