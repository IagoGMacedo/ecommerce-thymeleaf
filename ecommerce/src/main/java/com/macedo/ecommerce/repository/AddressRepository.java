package com.macedo.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

    
}
