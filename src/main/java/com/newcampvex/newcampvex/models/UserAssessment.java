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

@Document(collection = "user_assessments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAssessment {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    @Indexed
    private String assessmentId;
    
    private Integer score;
    private Integer totalMarks;
    private Integer correctAnswers;
    private Integer totalQuestions;
    private String status; // not-started, in-progress, completed
    private Long startedAt;
    private Long completedAt;
    private Integer timeSpent; // in seconds
    private Boolean isPassed;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
