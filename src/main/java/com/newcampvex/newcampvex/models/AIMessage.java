package com.newcampvex.newcampvex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "ai_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AIMessage {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    @Indexed
    private String conversationId;
    
    private String role; // user, assistant
    private String content;
    private String messageType; // text, code, question, answer
    private Boolean isHelpful;
    
    @CreatedDate
    private Instant createdAt;
}
