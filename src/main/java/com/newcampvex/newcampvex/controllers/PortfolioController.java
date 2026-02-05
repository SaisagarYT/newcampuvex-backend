package com.newcampvex.newcampvex.controllers;

import com.newcampvex.newcampvex.models.Portfolio;
import com.newcampvex.newcampvex.services.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PortfolioController {
    private final PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        try {
            Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPortfolio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable String id) {
        Optional<Portfolio> portfolio = portfolioService.getPortfolio(id);
        return portfolio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Portfolio> getPortfolioByUserId(@PathVariable String userId) {
        Optional<Portfolio> portfolio = portfolioService.getPortfolioByUserId(userId);
        return portfolio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable String id, @RequestBody Portfolio portfolio) {
        try {
            Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolio);
            return ResponseEntity.ok(updatedPortfolio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable String id) {
        try {
            portfolioService.deletePortfolio(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
