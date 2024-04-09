package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.Purchase;
import com.macedo.ecommerce.repository.PurchaseRepository;

@Component
public class PurchaseService {

    @Autowired
    PurchaseRepository PurchaseRepository;

    public List<Purchase> getPurchases(){
        return PurchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Integer id){
        return PurchaseRepository.findById(id).map(Purchase -> {
            return Purchase;
        }).orElseThrow(() -> null);
    }

    public void savePurchase(Purchase Purchase){
        PurchaseRepository.save(Purchase);
    }

    public void deletePurchase(Purchase Purchase){
        PurchaseRepository.delete(Purchase);
    }

    public void updatePurchase(Purchase Purchase){
        if(PurchaseRepository.existsById(Purchase.getId())){
            PurchaseRepository.save(Purchase);
        }
    }
    
}

