package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserStats;
import com.newcampvex.newcampvex.repositories.UserStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserStatsServiceImpl implements UserStatsService {
    private final UserStatsRepository userStatsRepository;

    @Override
    public UserStats createStats(UserStats stats) {
        return userStatsRepository.save(stats);
    }

    @Override
    public UserStats updateStats(String id, UserStats stats) {
        stats.setId(id);
        return userStatsRepository.save(stats);
    }

    @Override
    public Optional<UserStats> getStats(String id) {
        return userStatsRepository.findById(id);
    }

    @Override
    public Optional<UserStats> getStatsByUserId(String userId) {
        return userStatsRepository.findByUserId(userId);
    }

    @Override
    public void deleteStats(String id) {
        userStatsRepository.deleteById(id);
    }

    @Override
    public UserStats addXP(String userId, Long xp) {
        Optional<UserStats> stats = userStatsRepository.findByUserId(userId);
        if (stats.isPresent()) {
            UserStats userStats = stats.get();
            userStats.setTotalXP(userStats.getTotalXP() + xp);
            userStats.setLevel((int) (userStats.getTotalXP() / 1000) + 1);
            return userStatsRepository.save(userStats);
        }
        return null;
    }

    @Override
    public UserStats incrementProblemsSolved(String userId) {
        Optional<UserStats> stats = userStatsRepository.findByUserId(userId);
        if (stats.isPresent()) {
            UserStats userStats = stats.get();
            userStats.setProblemsSolved(userStats.getProblemsSolved() + 1);
            return userStatsRepository.save(userStats);
        }
        return null;
    }

    @Override
    public UserStats updateStreak(String userId) {
        Optional<UserStats> stats = userStatsRepository.findByUserId(userId);
        if (stats.isPresent()) {
            UserStats userStats = stats.get();
            userStats.setCurrentStreak(userStats.getCurrentStreak() + 1);
            if (userStats.getCurrentStreak() > userStats.getLongestStreak()) {
                userStats.setLongestStreak(userStats.getCurrentStreak());
            }
            return userStatsRepository.save(userStats);
        }
        return null;
    }
}
