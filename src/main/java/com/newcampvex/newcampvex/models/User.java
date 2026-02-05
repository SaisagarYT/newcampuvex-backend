package com.newcampvex.newcampvex.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "users")
@Getter
@Setter
@Builder
public class User {
    @Id
    private String id;
    @NonNull
    @Indexed(unique = true)
    private String username;
    @Indexed(unique = true)
    @NonNull
    private String email;
    @NonNull
    private String passwordHash;
    @NonNull
    private String fullName;
    @NonNull
    private UserRole role;
    private String bio;
    private boolean active = false; // default value
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    private Instant lastLoginAt;
}
