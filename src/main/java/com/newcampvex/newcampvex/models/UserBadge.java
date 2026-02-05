package com.newcampvex.newcampvex.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "user_badges")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBadge {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    @Indexed
    private String badgeId;
    
    private String badgeName;
    private String badgeImageUrl;
    private Integer count; // For multiple earned badges
    
    @CreatedDate
    private Instant earnedAt;
}
