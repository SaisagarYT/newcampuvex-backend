package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.UserAssessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAssessmentRepository extends MongoRepository<UserAssessment, String> {
    List<UserAssessment> findByUserId(String userId);
    Optional<UserAssessment> findByUserIdAndAssessmentId(String userId, String assessmentId);
    List<UserAssessment> findByAssessmentId(String assessmentId);
}
