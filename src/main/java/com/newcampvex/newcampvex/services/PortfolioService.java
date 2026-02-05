package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.Portfolio;
import java.util.Optional;

public interface PortfolioService {
    Portfolio createPortfolio(Portfolio portfolio);
    Portfolio updatePortfolio(String id, Portfolio portfolio);
    Optional<Portfolio> getPortfolio(String id);
    Optional<Portfolio> getPortfolioByUserId(String userId);
    void deletePortfolio(String id);
}
