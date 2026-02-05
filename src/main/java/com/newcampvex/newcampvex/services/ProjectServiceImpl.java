package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Project;
import com.newcampvex.newcampvex.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(String id, Project project) {
        project.setId(id);
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> getProject(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> getUserProjects(String userId) {
        return projectRepository.findByUserId(userId);
    }

    @Override
    public List<Project> getUserProjectsByStatus(String userId, String status) {
        return projectRepository.findByUserIdAndStatus(userId, status);
    }
}
