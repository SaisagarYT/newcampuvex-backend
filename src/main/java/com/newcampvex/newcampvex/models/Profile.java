package com.newcampvex.newcampvex.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String userId;
    
    private String bio;
    private String profilePictureUrl;
    private String skillsJson; // JSON string of skills
    private String experienceJson; // JSON string of experience
    private String educationJson; // JSON string of education
    private String portfolioUrl;
    private String resumeUrl;
    private String linkedInUrl;
    private String githubUrl;
    private String location;
    private String phone;
    
    @CreatedDate
    private Instant createdAt;
    
    @LastModifiedDate
    private Instant updatedAt;
}
