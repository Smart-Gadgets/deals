package org.example.repository;

import org.example.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealsRepository extends JpaRepository<Deal, String> {

    public Deal save(Deal deal);
    public Deal findDealByDealId(String dealId);
}
