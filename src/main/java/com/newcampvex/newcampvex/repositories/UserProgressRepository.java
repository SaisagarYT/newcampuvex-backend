package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.UserProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends MongoRepository<UserProgress, String> {
    List<UserProgress> findByUserId(String userId);
    Optional<UserProgress> findByUserIdAndProblemId(String userId, String problemId);
    List<UserProgress> findByUserIdAndStatus(String userId, String status);
}
