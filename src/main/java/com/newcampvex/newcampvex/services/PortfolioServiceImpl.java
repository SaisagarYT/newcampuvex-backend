package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Portfolio;
import com.newcampvex.newcampvex.repositories.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio updatePortfolio(String id, Portfolio portfolio) {
        portfolio.setId(id);
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Optional<Portfolio> getPortfolio(String id) {
        return portfolioRepository.findById(id);
    }

    @Override
    public Optional<Portfolio> getPortfolioByUserId(String userId) {
        return portfolioRepository.findByUserId(userId);
    }

    @Override
    public void deletePortfolio(String id) {
        portfolioRepository.deleteById(id);
    }
}
