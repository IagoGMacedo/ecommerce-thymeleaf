package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.CreditCard;
import com.macedo.ecommerce.repository.CreditCardRepository;

@Component
public class CreditCardService {

    @Autowired
    CreditCardRepository CreditCardRepository;

    public List<CreditCard> getCreditCards(){
        return CreditCardRepository.findAll();
    }

    public CreditCard getCreditCardById(Integer id){
        return CreditCardRepository.findById(id).map(CreditCard -> {
            return CreditCard;
        }).orElseThrow(() -> null);
    }

    public void saveCreditCard(CreditCard CreditCard){
        CreditCardRepository.save(CreditCard);
    }

    public void deleteCreditCard(CreditCard CreditCard){
        CreditCardRepository.delete(CreditCard);
    }

    public void updateCreditCard(CreditCard CreditCard){
        if(CreditCardRepository.existsById(CreditCard.getId())){
            CreditCardRepository.save(CreditCard);
        }
    }
    
}
