package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Roadmap;
import java.util.List;
import java.util.Optional;

public interface RoadmapService {
    Roadmap createRoadmap(Roadmap roadmap);
    Roadmap updateRoadmap(String id, Roadmap roadmap);
    Optional<Roadmap> getRoadmap(String id);
    void deleteRoadmap(String id);
    List<Roadmap> getAllRoadmaps();
    List<Roadmap> getRoadmapsByCategory(String category);
    List<Roadmap> getRoadmapsByDifficulty(String difficulty);
}
