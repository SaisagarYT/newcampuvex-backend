package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Assessment;
import com.newcampvex.newcampvex.services.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assessments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssessmentController {
    private final AssessmentService assessmentService;

    @PostMapping
    public ResponseEntity<Assessment> createAssessment(@RequestBody Assessment assessment) {
        try {
            Assessment createdAssessment = assessmentService.createAssessment(assessment);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAssessment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getAssessment(@PathVariable String id) {
        Optional<Assessment> assessment = assessmentService.getAssessment(id);
        return assessment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assessment> updateAssessment(@PathVariable String id, @RequestBody Assessment assessment) {
        try {
            Assessment updatedAssessment = assessmentService.updateAssessment(id, assessment);
            return ResponseEntity.ok(updatedAssessment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable String id) {
        try {
            assessmentService.deleteAssessment(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Assessment>> getAllAssessments() {
        List<Assessment> assessments = assessmentService.getAllAssessments();
        return ResponseEntity.ok(assessments);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Assessment>> getAssessmentsByCategory(@PathVariable String category) {
        List<Assessment> assessments = assessmentService.getAssessmentsByCategory(category);
        return ResponseEntity.ok(assessments);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<Assessment>> getAssessmentsByDifficulty(@PathVariable String difficulty) {
        List<Assessment> assessments = assessmentService.getAssessmentsByDifficulty(difficulty);
        return ResponseEntity.ok(assessments);
    }

    @GetMapping("/published")
    public ResponseEntity<List<Assessment>> getPublishedAssessments() {
        List<Assessment> assessments = assessmentService.getPublishedAssessments();
        return ResponseEntity.ok(assessments);
    }
}
