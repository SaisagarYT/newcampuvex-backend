package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.UserRoadmap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoadmapRepository extends MongoRepository<UserRoadmap, String> {
    List<UserRoadmap> findByUserId(String userId);
    Optional<UserRoadmap> findByUserIdAndRoadmapId(String userId, String roadmapId);
}
