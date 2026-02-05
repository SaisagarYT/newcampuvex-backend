package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Challenge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends MongoRepository<Challenge, String> {
    List<Challenge> findByStatus(String status);
    List<Challenge> findByDifficulty(String difficulty);
}
