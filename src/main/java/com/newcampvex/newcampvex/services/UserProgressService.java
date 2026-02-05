package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserProgress;

import java.util.List;
import java.util.Optional;

public interface UserProgressService {
    UserProgress createProgress(UserProgress progress);
    UserProgress updateProgress(String id, UserProgress progress);
    Optional<UserProgress> getProgress(String id);
    Optional<UserProgress> getProgressByUserAndProblem(String userId, String problemId);
    void deleteProgress(String id);
    List<UserProgress> getUserProgress(String userId);
    List<UserProgress> getUserProgressByStatus(String userId, String status);
}
