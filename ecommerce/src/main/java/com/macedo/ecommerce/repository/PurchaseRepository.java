package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{

    
}
