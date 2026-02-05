package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.AIMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AIMessageRepository extends MongoRepository<AIMessage, String> {
    List<AIMessage> findByConversationId(String conversationId);
    List<AIMessage> findByUserIdOrderByCreatedAtDesc(String userId);
}
