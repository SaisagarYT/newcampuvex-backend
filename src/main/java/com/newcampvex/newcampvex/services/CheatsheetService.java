package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Cheatsheet;
import java.util.List;
import java.util.Optional;

public interface CheatsheetService {
    Cheatsheet createCheatsheet(Cheatsheet cheatsheet);
    Cheatsheet updateCheatsheet(String id, Cheatsheet cheatsheet);
    Optional<Cheatsheet> getCheatsheet(String id);
    void deleteCheatsheet(String id);
    List<Cheatsheet> getAllCheatsheets();
    List<Cheatsheet> getCheatsheetsByCategory(String category);
    List<Cheatsheet> getCheatsheetsByDifficulty(String difficulty);
}
