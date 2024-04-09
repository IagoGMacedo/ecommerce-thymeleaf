package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem,Integer>{

    
}
