package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.UserChallenge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserChallengeRepository extends MongoRepository<UserChallenge, String> {
    List<UserChallenge> findByUserId(String userId);
    Optional<UserChallenge> findByUserIdAndChallengeId(String userId, String challengeId);
    List<UserChallenge> findByChallengeId(String challengeId);
}
