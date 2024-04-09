package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.ShoppingCart;
import com.macedo.ecommerce.repository.ShoppingCartRepository;

@Component
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository ShoppingCartRepository;

    public List<ShoppingCart> getShoppingCarts(){
        return ShoppingCartRepository.findAll();
    }

    public ShoppingCart getShoppingCartById(Integer id){
        return ShoppingCartRepository.findById(id).map(ShoppingCart -> {
            return ShoppingCart;
        }).orElseThrow(() -> null);
    }

    public void saveShoppingCart(ShoppingCart ShoppingCart){
        ShoppingCartRepository.save(ShoppingCart);
    }

    public void deleteShoppingCart(ShoppingCart ShoppingCart){
        ShoppingCartRepository.delete(ShoppingCart);
    }

    public void updateShoppingCart(ShoppingCart ShoppingCart){
        if(ShoppingCartRepository.existsById(ShoppingCart.getId())){
            ShoppingCartRepository.save(ShoppingCart);
        }
    }
    
}

