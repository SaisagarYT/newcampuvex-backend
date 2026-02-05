package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserProgress;
import com.newcampvex.newcampvex.repositories.UserProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProgressServiceImpl implements UserProgressService {
    private final UserProgressRepository userProgressRepository;

    @Override
    public UserProgress createProgress(UserProgress progress) {
        return userProgressRepository.save(progress);
    }

    @Override
    public UserProgress updateProgress(String id, UserProgress progress) {
        progress.setId(id);
        return userProgressRepository.save(progress);
    }

    @Override
    public Optional<UserProgress> getProgress(String id) {
        return userProgressRepository.findById(id);
    }

    @Override
    public Optional<UserProgress> getProgressByUserAndProblem(String userId, String problemId) {
        return userProgressRepository.findByUserIdAndProblemId(userId, problemId);
    }

    @Override
    public void deleteProgress(String id) {
        userProgressRepository.deleteById(id);
    }

    @Override
    public List<UserProgress> getUserProgress(String userId) {
        return userProgressRepository.findByUserId(userId);
    }

    @Override
    public List<UserProgress> getUserProgressByStatus(String userId, String status) {
        return userProgressRepository.findByUserIdAndStatus(userId, status);
    }
}
