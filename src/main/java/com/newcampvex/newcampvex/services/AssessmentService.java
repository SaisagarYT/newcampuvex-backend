package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Assessment;
import java.util.List;
import java.util.Optional;

public interface AssessmentService {
    Assessment createAssessment(Assessment assessment);
    Assessment updateAssessment(String id, Assessment assessment);
    Optional<Assessment> getAssessment(String id);
    void deleteAssessment(String id);
    List<Assessment> getAllAssessments();
    List<Assessment> getAssessmentsByCategory(String category);
    List<Assessment> getAssessmentsByDifficulty(String difficulty);
    List<Assessment> getPublishedAssessments();
}
