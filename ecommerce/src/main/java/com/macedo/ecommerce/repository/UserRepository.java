package com.macedo.ecommerce.repository;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.macedo.ecommerce.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer>{

    User findByEmail(String email);
}
