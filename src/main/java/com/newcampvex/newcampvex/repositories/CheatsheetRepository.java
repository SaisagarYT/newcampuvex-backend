package com.newcampvex.newcampvex.repositories;

import com.newcampvex.newcampvex.models.Cheatsheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheatsheetRepository extends MongoRepository<Cheatsheet, String> {
    List<Cheatsheet> findByCategory(String category);
    List<Cheatsheet> findByDifficulty(String difficulty);
}
