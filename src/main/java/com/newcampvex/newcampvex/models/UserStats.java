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

@Document(collection = "user_stats")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStats {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String userId;
    
    private Long totalXP;
    private Integer level;
    private Integer problemsSolved;
    private Integer questionsAttempted;
    private Integer quizzesCompleted;
    private Integer assessmentsPassed;
    private Integer currentStreak; // Consecutive days
    private Integer longestStreak;
    private Double averageScore;
    private Integer totalMinutesCoded;
    private Integer aptitudeScore;
    private Integer dSAScore;
    private Integer codingScore;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
