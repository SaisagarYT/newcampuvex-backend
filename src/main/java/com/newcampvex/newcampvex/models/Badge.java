package com.newcampvex.newcampvex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "badges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Badge {
    @Id
    private String id;
    
    private String name;
    private String description;
    private String imageUrl;
    private String badgeType; // achievement, milestone, streak, skill
    private Integer requiredCount; // For milestone badges
    private String color;
    private Boolean isActive;
    
    @CreatedDate
    private Instant createdAt;
}
