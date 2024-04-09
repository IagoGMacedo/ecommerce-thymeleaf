package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    
}
