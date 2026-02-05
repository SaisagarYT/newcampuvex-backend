package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserAssessment;
import com.newcampvex.newcampvex.repositories.UserAssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAssessmentServiceImpl {
    private final UserAssessmentRepository userAssessmentRepository;

    public UserAssessment createUserAssessment(UserAssessment userAssessment) {
        return userAssessmentRepository.save(userAssessment);
    }

    public Optional<UserAssessment> getUserAssessment(String userId, String assessmentId) {
        return userAssessmentRepository.findByUserIdAndAssessmentId(userId, assessmentId);
    }

    public List<UserAssessment> getUserAssessments(String userId) {
        return userAssessmentRepository.findByUserId(userId);
    }

    public List<UserAssessment> getAssessmentAttempts(String assessmentId) {
        return userAssessmentRepository.findByAssessmentId(assessmentId);
    }

    public UserAssessment updateUserAssessment(String id, UserAssessment userAssessment) {
        userAssessment.setId(id);
        return userAssessmentRepository.save(userAssessment);
    }

    public void deleteUserAssessment(String id) {
        userAssessmentRepository.deleteById(id);
    }
}
