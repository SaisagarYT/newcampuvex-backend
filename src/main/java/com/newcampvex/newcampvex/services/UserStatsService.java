package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserStats;
import java.util.Optional;

public interface UserStatsService {
    UserStats createStats(UserStats stats);
    UserStats updateStats(String id, UserStats stats);
    Optional<UserStats> getStats(String id);
    Optional<UserStats> getStatsByUserId(String userId);
    void deleteStats(String id);
    UserStats addXP(String userId, Long xp);
    UserStats incrementProblemsSolved(String userId);
    UserStats updateStreak(String userId);
}
