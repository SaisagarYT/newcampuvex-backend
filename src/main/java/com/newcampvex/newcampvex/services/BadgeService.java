package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Badge;
import java.util.List;
import java.util.Optional;

public interface BadgeService {
    Badge createBadge(Badge badge);
    Badge updateBadge(String id, Badge badge);
    Optional<Badge> getBadge(String id);
    void deleteBadge(String id);
    List<Badge> getAllBadges();
    List<Badge> getBadgesByType(String type);
}
