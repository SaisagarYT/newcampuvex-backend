package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.InterviewQuestion;
import com.newcampvex.newcampvex.services.InterviewQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interview-questions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InterviewQuestionController {
    private final InterviewQuestionService interviewQuestionService;

    @PostMapping
    public ResponseEntity<InterviewQuestion> createQuestion(@RequestBody InterviewQuestion question) {
        try {
            InterviewQuestion createdQuestion = interviewQuestionService.createQuestion(question);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewQuestion> getQuestion(@PathVariable String id) {
        Optional<InterviewQuestion> question = interviewQuestionService.getQuestion(id);
        return question.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewQuestion> updateQuestion(@PathVariable String id, @RequestBody InterviewQuestion question) {
        try {
            InterviewQuestion updatedQuestion = interviewQuestionService.updateQuestion(id, question);
            return ResponseEntity.ok(updatedQuestion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable String id) {
        try {
            interviewQuestionService.deleteQuestion(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<InterviewQuestion>> getAllQuestions() {
        List<InterviewQuestion> questions = interviewQuestionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<InterviewQuestion>> getQuestionsByCategory(@PathVariable String category) {
        List<InterviewQuestion> questions = interviewQuestionService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/difficulty/{difficulty}")
    public ResponseEntity<List<InterviewQuestion>> getQuestionsByDifficulty(@PathVariable String difficulty) {
        List<InterviewQuestion> questions = interviewQuestionService.getQuestionsByDifficulty(difficulty);
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<InterviewQuestion>> getQuestionsByTopic(@PathVariable String topic) {
        List<InterviewQuestion> questions = interviewQuestionService.getQuestionsByTopic(topic);
        return ResponseEntity.ok(questions);
    }
}
