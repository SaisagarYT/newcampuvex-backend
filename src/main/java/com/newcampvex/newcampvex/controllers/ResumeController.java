package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Resume;
import com.newcampvex.newcampvex.services.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResumeController {
    private final ResumeService resumeService;

    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody Resume resume) {
        try {
            Resume createdResume = resumeService.createResume(resume);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdResume);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResume(@PathVariable String id) {
        Optional<Resume> resume = resumeService.getResume(id);
        return resume.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable String id, @RequestBody Resume resume) {
        try {
            Resume updatedResume = resumeService.updateResume(id, resume);
            return ResponseEntity.ok(updatedResume);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable String id) {
        try {
            resumeService.deleteResume(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Resume>> getUserResumes(@PathVariable String userId) {
        List<Resume> resumes = resumeService.getUserResumes(userId);
        return ResponseEntity.ok(resumes);
    }

    @GetMapping("/user/{userId}/default")
    public ResponseEntity<Resume> getDefaultResume(@PathVariable String userId) {
        Optional<Resume> resume = resumeService.getDefaultResume(userId);
        return resume.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
