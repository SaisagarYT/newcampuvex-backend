package com.newcampvex.newcampvex.models;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "problems")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Problem {
    @Id
    private String id;
    
    private String title;
    private String description;
    private String difficulty;
    private String category;
    private String platform;
    private String externalLink;
    private Integer xpReward;
    private List<String> tags;
    private String sampleInput;
    private String sampleOutput;
    private List<String> testCases;
    private Integer solutionsCount;
    private Double successRate;
    private String timeComplexity;
    private String spaceComplexity;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
