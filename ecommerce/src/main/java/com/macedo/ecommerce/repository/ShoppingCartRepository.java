package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Integer>{

    
}
