package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Badge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends MongoRepository<Badge, String> {
    List<Badge> findByBadgeType(String badgeType);
    Badge findByName(String name);
}
