package com.newcampvex.newcampvex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "assessments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assessment {
    @Id
    private String id;
    
    private String title;
    private String description;
    private String category; // aptitude, dsa, coding, etc.
    private String difficulty;
    private Integer totalQuestions;
    private Integer timeLimit; // in minutes
    private List<String> questionIds;
    private String passingScore; // percentage
    private Integer xpReward;
    private Boolean isPublished;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
