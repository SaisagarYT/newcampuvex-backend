package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Problem;
import com.newcampvex.newcampvex.repositories.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProblemServiceImpl implements ProblemService {
    private final ProblemRepository problemRepository;

    @Override
    public Problem createProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public Problem updateProblem(String id, Problem problem) {
        problem.setId(id);
        return problemRepository.save(problem);
    }

    @Override
    public Optional<Problem> getProblem(String id) {
        return problemRepository.findById(id);
    }

    @Override
    public void deleteProblem(String id) {
        problemRepository.deleteById(id);
    }

    @Override
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @Override
    public List<Problem> getProblemsByCategory(String category) {
        return problemRepository.findByCategory(category);
    }

    @Override
    public List<Problem> getProblemsByDifficulty(String difficulty) {
        return problemRepository.findByDifficulty(difficulty);
    }

    @Override
    public List<Problem> getProblemsByPlatform(String platform) {
        return problemRepository.findByPlatform(platform);
    }

    @Override
    public List<Problem> getProblemsByCategoryAndDifficulty(String category, String difficulty) {
        return problemRepository.findByCategoryAndDifficulty(category, difficulty);
    }
}
