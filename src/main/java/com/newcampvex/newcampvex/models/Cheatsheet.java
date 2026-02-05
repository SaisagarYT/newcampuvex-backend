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

@Document(collection = "cheatsheets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cheatsheet {
    @Id
    private String id;
    
    private String title;
    private String category; // Backend, DSA, Databases, etc.
    private Integer topicsCount;
    private Integer examplesCount;
    private String difficulty;
    private String description;
    private String contentJson; // JSON format of topics and examples
    private List<String> tags;
    private Integer viewCount;
    private Long downloads;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
