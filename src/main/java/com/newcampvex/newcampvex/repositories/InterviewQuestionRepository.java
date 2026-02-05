package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.InterviewQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewQuestionRepository extends MongoRepository<InterviewQuestion, String> {
    List<InterviewQuestion> findByCategory(String category);
    List<InterviewQuestion> findByDifficulty(String difficulty);
    List<InterviewQuestion> findByTopic(String topic);
    List<InterviewQuestion> findByCategoryAndDifficulty(String category, String difficulty);
}
