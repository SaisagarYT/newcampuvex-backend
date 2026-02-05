package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.UserBadge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBadgeRepository extends MongoRepository<UserBadge, String> {
    List<UserBadge> findByUserId(String userId);
    List<UserBadge> findByUserIdAndBadgeId(String userId, String badgeId);
}
