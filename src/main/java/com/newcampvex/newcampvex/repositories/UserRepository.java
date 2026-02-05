package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndActiveTrue(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByIdAndActiveTrue(String id);
}




