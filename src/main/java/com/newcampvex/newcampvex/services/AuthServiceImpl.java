package com.newcampvex.newcampvex.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newcampvex.newcampvex.models.User;
import com.newcampvex.newcampvex.repositories.UserRepository;
import com.newcampvex.newcampvex.util.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    private static final int COOKIE_MAX_AGE = 24 * 60 * 60; // 24 hours in seconds

    @Override
    public User login(String username, String password, HttpServletResponse response) {
        Optional<User> userOptional = userRepository.findByUsernameAndActiveTrue(username);
        
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        // Update last login
        user.setLastLoginAt(Instant.now());
        userRepository.save(user);

        // Generate JWT token
        String token = jwtUtil.generateToken(user);

        // Create and add cookie
        Cookie authCookie = new Cookie("authToken", token);
        authCookie.setHttpOnly(true);
        authCookie.setSecure(false); // Set to true in production with HTTPS
        authCookie.setPath("/");
        authCookie.setMaxAge(COOKIE_MAX_AGE);
        response.addCookie(authCookie);
        response.addHeader("Set-Cookie", "authToken=" + token + "; SameSite=Strict; Path=/; HttpOnly");

        // Also add userId cookie for convenience
        Cookie userIdCookie = new Cookie("userId", user.getId());
        userIdCookie.setHttpOnly(false);
        userIdCookie.setSecure(false); // Set to true in production with HTTPS
        userIdCookie.setPath("/");
        userIdCookie.setMaxAge(COOKIE_MAX_AGE);
        response.addCookie(userIdCookie);
        response.addHeader("Set-Cookie", "userId=" + user.getId() + "; SameSite=Strict; Path=/");

        return user;
    }

    @Override
    public void logout(HttpServletResponse response) {
        // Clear authentication cookie
        Cookie authCookie = new Cookie("authToken", null);
        authCookie.setHttpOnly(true);
        authCookie.setPath("/");
        authCookie.setMaxAge(0);
        response.addCookie(authCookie);

        // Clear userId cookie
        Cookie userIdCookie = new Cookie("userId", null);
        userIdCookie.setHttpOnly(false);
        userIdCookie.setPath("/");
        userIdCookie.setMaxAge(0);
        response.addCookie(userIdCookie);

        // Clear security context
        SecurityContextHolder.clearContext();
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            Optional<User> user = userRepository.findByUsernameAndActiveTrue(username);
            return user.orElse(null);
        }

        return null;
    }

    @Override
    public boolean validateToken(String token) {
        try {
            return jwtUtil.validateToken(token);
        } catch (Exception e) {
            return false;
        }
    }
}
