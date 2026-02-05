package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.UserBadge;
import com.newcampvex.newcampvex.repositories.UserBadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserBadgeServiceImpl {
    private final UserBadgeRepository userBadgeRepository;

    public UserBadge awardBadge(UserBadge userBadge) {
        return userBadgeRepository.save(userBadge);
    }

    public List<UserBadge> getUserBadges(String userId) {
        return userBadgeRepository.findByUserId(userId);
    }

    public List<UserBadge> checkIfBadgeEarned(String userId, String badgeId) {
        return userBadgeRepository.findByUserIdAndBadgeId(userId, badgeId);
    }

    public void removeBadge(String id) {
        userBadgeRepository.deleteById(id);
    }
}
