package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Assessment;
import com.newcampvex.newcampvex.repositories.AssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;

    @Override
    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public Assessment updateAssessment(String id, Assessment assessment) {
        assessment.setId(id);
        return assessmentRepository.save(assessment);
    }

    @Override
    public Optional<Assessment> getAssessment(String id) {
        return assessmentRepository.findById(id);
    }

    @Override
    public void deleteAssessment(String id) {
        assessmentRepository.deleteById(id);
    }

    @Override
    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    @Override
    public List<Assessment> getAssessmentsByCategory(String category) {
        return assessmentRepository.findByCategory(category);
    }

    @Override
    public List<Assessment> getAssessmentsByDifficulty(String difficulty) {
        return assessmentRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<Assessment> getPublishedAssessments() {
        return assessmentRepository.findByIsPublished(true);
    }
}
