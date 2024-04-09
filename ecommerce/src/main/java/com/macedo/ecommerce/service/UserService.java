package com.macedo.ecommerce.service;

import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.Address;
import com.macedo.ecommerce.model.CreditCard;
import com.macedo.ecommerce.model.ProductItem;
import com.macedo.ecommerce.model.Purchase;
import com.macedo.ecommerce.model.Role;
import com.macedo.ecommerce.model.ShoppingCart;
import com.macedo.ecommerce.model.User;
import com.macedo.ecommerce.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    UserRepository UserRepository;

    public List<User> getUsers(){
        return UserRepository.findAll();
    }

    public User getUserById(Integer id){
        return UserRepository.findById(id).map(User -> {
            return User;
        }).orElseThrow(() -> null);
    }

    public void saveUser(User User){
        //inicializando variáveis para evitar erros

        User.setAddress(new Address());
        User.setCreditCards(new ArrayList<CreditCard>());
        User.setPurchases(new ArrayList<Purchase>());
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTotalPrice(BigDecimal.ZERO);
        shoppingCart.setProductItems(new ArrayList<ProductItem>());
        User.setShoppingCart(shoppingCart);



        UserRepository.save(User);
        System.out.println("usuário salvo com sucesso");
    }

    public void deleteUser(User User){
        UserRepository.delete(User);
    }

    public void updateUser(User User){
        if(UserRepository.existsById(User.getId())){
            UserRepository.save(User);
        }
    }

    public User getUserByEmail(String email){
        User findUser = UserRepository.findByEmail(email);
        return findUser;

    }
    
}

