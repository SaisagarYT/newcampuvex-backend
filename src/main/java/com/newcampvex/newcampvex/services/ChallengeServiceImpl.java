package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Challenge;
import com.newcampvex.newcampvex.repositories.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;

    @Override
    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    @Override
    public Challenge updateChallenge(String id, Challenge challenge) {
        challenge.setId(id);
        return challengeRepository.save(challenge);
    }

    @Override
    public Optional<Challenge> getChallenge(String id) {
        return challengeRepository.findById(id);
    }

    @Override
    public void deleteChallenge(String id) {
        challengeRepository.deleteById(id);
    }

    @Override
    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    @Override
    public List<Challenge> getChallengesByStatus(String status) {
        return challengeRepository.findByStatus(status);
    }

    @Override
    public List<Challenge> getChallengesByDifficulty(String difficulty) {
        return challengeRepository.findByDifficulty(difficulty);
    }
}
