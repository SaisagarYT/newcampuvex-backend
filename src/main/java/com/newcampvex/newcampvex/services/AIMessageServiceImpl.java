package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.AIMessage;
import com.newcampvex.newcampvex.repositories.AIMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AIMessageServiceImpl {
    private final AIMessageRepository aiMessageRepository;

    public AIMessage saveMessage(AIMessage message) {
        return aiMessageRepository.save(message);
    }

    public List<AIMessage> getConversation(String conversationId) {
        return aiMessageRepository.findByConversationId(conversationId);
    }

    public List<AIMessage> getUserMessages(String userId) {
        return aiMessageRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    public Optional<AIMessage> getMessage(String messageId) {
        return aiMessageRepository.findById(messageId);
    }
}
