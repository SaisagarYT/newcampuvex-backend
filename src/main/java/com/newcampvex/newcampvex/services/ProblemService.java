package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Problem;

import java.util.List;
import java.util.Optional;

public interface ProblemService {
    Problem createProblem(Problem problem);
    Problem updateProblem(String id, Problem problem);
    Optional<Problem> getProblem(String id);
    void deleteProblem(String id);
    List<Problem> getAllProblems();
    List<Problem> getProblemsByCategory(String category);
    List<Problem> getProblemsByDifficulty(String difficulty);
    List<Problem> getProblemsByPlatform(String platform);
    List<Problem> getProblemsByCategoryAndDifficulty(String category, String difficulty);
}
