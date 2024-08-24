package org.example.repository;

import org.example.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transactions, Long> {
    public List<Transactions> findAllByDealId(String dealId);
    public List<Transactions> findAllByDealIdAndUserId(String dealId, String userId);
}
