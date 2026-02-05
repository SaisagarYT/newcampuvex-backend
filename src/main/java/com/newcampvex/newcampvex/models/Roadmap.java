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

@Document(collection = "roadmaps")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roadmap {
    @Id
    private String id;
    
    private String title;
    private String description;
    private String category; // Frontend, Backend, Full-Stack, DSA, etc.
    private String difficulty;
    private String milestoneJson; // JSON array of milestones
    private Integer totalMilestones;
    private Long estimatedHours;
    private List<String> resourceIds;
    private Integer followersCount;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
