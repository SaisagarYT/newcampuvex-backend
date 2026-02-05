package com.newcampvex.newcampvex.services;

import com.newcampvex.newcampvex.models.XPTransaction;
import com.newcampvex.newcampvex.repositories.XPTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class XPTransactionServiceImpl {
    private final XPTransactionRepository xpTransactionRepository;

    public XPTransaction createTransaction(XPTransaction transaction) {
        return xpTransactionRepository.save(transaction);
    }

    public List<XPTransaction> getUserTransactions(String userId) {
        return xpTransactionRepository.findByUserId(userId);
    }

    public List<XPTransaction> getUserTransactionsByType(String userId, String activityType) {
        return xpTransactionRepository.findByUserIdAndActivityType(userId, activityType);
    }
}
