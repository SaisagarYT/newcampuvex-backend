package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.InterviewQuestion;
import java.util.List;
import java.util.Optional;

public interface InterviewQuestionService {
    InterviewQuestion createQuestion(InterviewQuestion question);
    InterviewQuestion updateQuestion(String id, InterviewQuestion question);
    Optional<InterviewQuestion> getQuestion(String id);
    void deleteQuestion(String id);
    List<InterviewQuestion> getAllQuestions();
    List<InterviewQuestion> getQuestionsByCategory(String category);
    List<InterviewQuestion> getQuestionsByDifficulty(String difficulty);
    List<InterviewQuestion> getQuestionsByTopic(String topic);
}
