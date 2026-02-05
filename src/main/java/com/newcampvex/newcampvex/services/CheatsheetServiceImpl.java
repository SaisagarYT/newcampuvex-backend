package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Cheatsheet;
import com.newcampvex.newcampvex.repositories.CheatsheetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheatsheetServiceImpl implements CheatsheetService {
    private final CheatsheetRepository cheatsheetRepository;

    @Override
    public Cheatsheet createCheatsheet(Cheatsheet cheatsheet) {
        return cheatsheetRepository.save(cheatsheet);
    }

    @Override
    public Cheatsheet updateCheatsheet(String id, Cheatsheet cheatsheet) {
        cheatsheet.setId(id);
        return cheatsheetRepository.save(cheatsheet);
    }

    @Override
    public Optional<Cheatsheet> getCheatsheet(String id) {
        return cheatsheetRepository.findById(id);
    }

    @Override
    public void deleteCheatsheet(String id) {
        cheatsheetRepository.deleteById(id);
    }

    @Override
    public List<Cheatsheet> getAllCheatsheets() {
        return cheatsheetRepository.findAll();
    }

    @Override
    public List<Cheatsheet> getCheatsheetsByCategory(String category) {
        return cheatsheetRepository.findByCategory(category);
    }

    @Override
    public List<Cheatsheet> getCheatsheetsByDifficulty(String difficulty) {
        return cheatsheetRepository.findByDifficulty(difficulty);
    }
}
