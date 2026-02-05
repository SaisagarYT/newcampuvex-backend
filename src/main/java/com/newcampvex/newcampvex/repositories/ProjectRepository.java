package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findByUserId(String userId);
    List<Project> findByUserIdAndStatus(String userId, String status);
}
