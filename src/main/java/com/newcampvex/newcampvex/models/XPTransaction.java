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

@Document(collection = "xp_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class XPTransaction {
    @Id
    private String id;
    
    @Indexed
    private String userId;
    
    private Integer xpAmount;
    private String activityType; // problem_solved, quiz_completed, assessment_passed, etc.
    private String activityId; // Reference to problem/quiz/assessment
    private String description;
    private Long timestamp;
    
    @CreatedDate
    private Instant createdAt;
}
