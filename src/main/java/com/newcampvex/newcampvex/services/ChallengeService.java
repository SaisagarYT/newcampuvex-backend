package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Challenge;
import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    Challenge createChallenge(Challenge challenge);
    Challenge updateChallenge(String id, Challenge challenge);
    Optional<Challenge> getChallenge(String id);
    void deleteChallenge(String id);
    List<Challenge> getAllChallenges();
    List<Challenge> getChallengesByStatus(String status);
    List<Challenge> getChallengesByDifficulty(String difficulty);
}
