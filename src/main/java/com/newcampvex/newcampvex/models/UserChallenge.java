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

@Document(collection = "user_challenges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChallenge {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    @Indexed
    private String challengeId;
    
    private Integer problemsSolved;
    private Integer totalProblems;
    private Integer rank;
    private Integer score;
    private String status; // not-started, in-progress, completed
    
    @CreatedDate
    private Instant startedAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
