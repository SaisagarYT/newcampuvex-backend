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

@Document(collection = "user_progress")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProgress {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    @Indexed
    private String problemId;
    
    private String status; // not-started, solving, solved
    private Integer attempts;
    private Long lastSolvedTime;
    private String language;
    private String solution;
    private Integer timeSpent; // in seconds
    private Boolean isOptimal;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
