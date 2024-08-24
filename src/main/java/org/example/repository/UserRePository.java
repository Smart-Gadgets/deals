package org.example.repository;

import org.example.model.Deal;
import org.example.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRePository extends JpaRepository<Seller, String> {

    public Seller save(Deal deal);
    public Seller findDealByUserId(String userId);
}
