package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.User;

public interface UserService {
    User registerUser(
            String username,
            String email,
            String rawPassword,
            String fulname,
            String role
    );

    User getActiveUserById(String userId);
    void updateLastLogin(String userId);
}
