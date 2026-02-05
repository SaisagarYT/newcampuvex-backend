package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserChallenge;
import com.newcampvex.newcampvex.repositories.UserChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserChallengeServiceImpl {
    private final UserChallengeRepository userChallengeRepository;

    public UserChallenge createUserChallenge(UserChallenge userChallenge) {
        return userChallengeRepository.save(userChallenge);
    }

    public Optional<UserChallenge> getUserChallenge(String userId, String challengeId) {
        return userChallengeRepository.findByUserIdAndChallengeId(userId, challengeId);
    }

    public List<UserChallenge> getUserChallenges(String userId) {
        return userChallengeRepository.findByUserId(userId);
    }

    public List<UserChallenge> getChallengParticipants(String challengeId) {
        return userChallengeRepository.findByChallengeId(challengeId);
    }

    public UserChallenge updateUserChallenge(String id, UserChallenge userChallenge) {
        userChallenge.setId(id);
        return userChallengeRepository.save(userChallenge);
    }

    public void deleteUserChallenge(String id) {
        userChallengeRepository.deleteById(id);
    }
}
