package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.User;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    User login(String username, String password, HttpServletResponse response);
    void logout(HttpServletResponse response);
    User getCurrentUser();
    boolean validateToken(String token);
}
