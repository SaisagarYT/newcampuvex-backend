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

@Document(collection = "user_roadmaps")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoadmap {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    @Indexed
    private String roadmapId;
    
    private Integer completedMilestones;
    private Integer totalMilestones;
    private String status; // not-started, in-progress, completed
    private Long startedAt;
    private Long completedAt;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
