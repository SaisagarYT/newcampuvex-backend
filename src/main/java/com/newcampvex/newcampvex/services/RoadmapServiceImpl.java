package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Roadmap;
import com.newcampvex.newcampvex.repositories.RoadmapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoadmapServiceImpl implements RoadmapService {
    private final RoadmapRepository roadmapRepository;

    @Override
    public Roadmap createRoadmap(Roadmap roadmap) {
        return roadmapRepository.save(roadmap);
    }

    @Override
    public Roadmap updateRoadmap(String id, Roadmap roadmap) {
        roadmap.setId(id);
        return roadmapRepository.save(roadmap);
    }

    @Override
    public Optional<Roadmap> getRoadmap(String id) {
        return roadmapRepository.findById(id);
    }

    @Override
    public void deleteRoadmap(String id) {
        roadmapRepository.deleteById(id);
    }

    @Override
    public List<Roadmap> getAllRoadmaps() {
        return roadmapRepository.findAll();
    }

    @Override
    public List<Roadmap> getRoadmapsByCategory(String category) {
        return roadmapRepository.findByCategory(category);
    }

    @Override
    public List<Roadmap> getRoadmapsByDifficulty(String difficulty) {
        return roadmapRepository.findByDifficulty(difficulty);
    }
}
