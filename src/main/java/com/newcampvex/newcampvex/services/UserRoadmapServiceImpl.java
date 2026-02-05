package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserRoadmap;
import com.newcampvex.newcampvex.repositories.UserRoadmapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoadmapServiceImpl {
    private final UserRoadmapRepository userRoadmapRepository;

    public UserRoadmap createUserRoadmap(UserRoadmap userRoadmap) {
        return userRoadmapRepository.save(userRoadmap);
    }

    public Optional<UserRoadmap> getUserRoadmap(String userId, String roadmapId) {
        return userRoadmapRepository.findByUserIdAndRoadmapId(userId, roadmapId);
    }

    public List<UserRoadmap> getUserRoadmaps(String userId) {
        return userRoadmapRepository.findByUserId(userId);
    }

    public UserRoadmap updateUserRoadmap(String id, UserRoadmap userRoadmap) {
        userRoadmap.setId(id);
        return userRoadmapRepository.save(userRoadmap);
    }

    public void deleteUserRoadmap(String id) {
        userRoadmapRepository.deleteById(id);
    }
}
