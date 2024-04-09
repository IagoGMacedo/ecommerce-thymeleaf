package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer>{

    
}
