package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends MongoRepository<Assessment, String> {
    List<Assessment> findByCategory(String category);
    List<Assessment> findByDifficulty(String difficulty);
    List<Assessment> findByIsPublished(Boolean isPublished);
}
