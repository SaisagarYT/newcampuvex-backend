package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Roadmap;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoadmapRepository extends MongoRepository<Roadmap, String> {
    List<Roadmap> findByCategory(String category);
    List<Roadmap> findByDifficulty(String difficulty);
}
