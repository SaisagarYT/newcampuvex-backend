package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Problem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends MongoRepository<Problem, String> {
    List<Problem> findByCategory(String category);
    List<Problem> findByDifficulty(String difficulty);
    List<Problem> findByPlatform(String platform);
    List<Problem> findByCategoryAndDifficulty(String category, String difficulty);
}
