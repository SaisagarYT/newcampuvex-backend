package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.XPTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XPTransactionRepository extends MongoRepository<XPTransaction, String> {
    List<XPTransaction> findByUserId(String userId);
    List<XPTransaction> findByUserIdAndActivityType(String userId, String activityType);
}
