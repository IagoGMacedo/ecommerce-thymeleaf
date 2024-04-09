package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard,Integer>{

    
}
