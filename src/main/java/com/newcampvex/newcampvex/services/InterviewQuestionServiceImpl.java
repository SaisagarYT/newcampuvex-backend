package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.InterviewQuestion;
import com.newcampvex.newcampvex.repositories.InterviewQuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterviewQuestionServiceImpl implements InterviewQuestionService {
    private final InterviewQuestionRepository interviewQuestionRepository;

    @Override
    public InterviewQuestion createQuestion(InterviewQuestion question) {
        return interviewQuestionRepository.save(question);
    }

    @Override
    public InterviewQuestion updateQuestion(String id, InterviewQuestion question) {
        question.setId(id);
        return interviewQuestionRepository.save(question);
    }

    @Override
    public Optional<InterviewQuestion> getQuestion(String id) {
        return interviewQuestionRepository.findById(id);
    }

    @Override
    public void deleteQuestion(String id) {
        interviewQuestionRepository.deleteById(id);
    }

    @Override
    public List<InterviewQuestion> getAllQuestions() {
        return interviewQuestionRepository.findAll();
    }

    @Override
    public List<InterviewQuestion> getQuestionsByCategory(String category) {
        return interviewQuestionRepository.findByCategory(category);
    }

    @Override
    public List<InterviewQuestion> getQuestionsByDifficulty(String difficulty) {
        return interviewQuestionRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<InterviewQuestion> getQuestionsByTopic(String topic) {
        return interviewQuestionRepository.findByTopic(topic);
    }
}
