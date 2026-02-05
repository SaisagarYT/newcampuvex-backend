package com.newcampvex.newcampvex.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newcampvex.newcampvex.models.User;
import com.newcampvex.newcampvex.models.UserRole;
import com.newcampvex.newcampvex.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public User registerUser(String username, String email, String rawPassword, String fullName, String role) {
        // Check if user already exists
        if (userRepository.existsByUsername(username) || userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Username or email already exists");
        }
        
        // Encode the password
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // Create new user
        User user = User.builder()
                .username(username)
                .email(email)
                .passwordHash(encodedPassword)
                .fullName(fullName)
                .role(UserRole.USER)
                .active(true)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
        
        return userRepository.save(user);
    }

    @Override
    public User getActiveUserById(String userId) {
        Optional<User> user = userRepository.findByIdAndActiveTrue(userId);
        return user.orElseThrow(() -> new RuntimeException("Active user not found with ID: " + userId));
    }

    @Override
    public void updateLastLogin(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setLastLoginAt(Instant.now());
            userRepository.save(user);
        }
    }
}
