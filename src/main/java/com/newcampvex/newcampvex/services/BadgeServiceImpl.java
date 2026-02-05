package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Badge;
import com.newcampvex.newcampvex.repositories.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {
    private final BadgeRepository badgeRepository;

    @Override
    public Badge createBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public Badge updateBadge(String id, Badge badge) {
        badge.setId(id);
        return badgeRepository.save(badge);
    }

    @Override
    public Optional<Badge> getBadge(String id) {
        return badgeRepository.findById(id);
    }

    @Override
    public void deleteBadge(String id) {
        badgeRepository.deleteById(id);
    }

    @Override
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public List<Badge> getBadgesByType(String type) {
        return badgeRepository.findByBadgeType(type);
    }
}
