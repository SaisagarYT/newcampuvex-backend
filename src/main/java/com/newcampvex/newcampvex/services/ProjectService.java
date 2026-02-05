package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Project;
import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project createProject(Project project);
    Project updateProject(String id, Project project);
    Optional<Project> getProject(String id);
    void deleteProject(String id);
    List<Project> getUserProjects(String userId);
    List<Project> getUserProjectsByStatus(String userId, String status);
}
