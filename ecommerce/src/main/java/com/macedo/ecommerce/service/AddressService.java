package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.Address;
import com.macedo.ecommerce.repository.AddressRepository;

@Component
public class AddressService {

    @Autowired
    AddressRepository AddressRepository;

    public List<Address> getAddresses(){
        return AddressRepository.findAll();
    }

    public Address getAddressById(Integer id){
        return AddressRepository.findById(id).map(Address -> {
            return Address;
        }).orElseThrow(() -> null);
    }

    public void saveAddress(Address Address){
        AddressRepository.save(Address);
    }

    public void deleteAddress(Address Address){
        AddressRepository.delete(Address);
    }

    public void updateAddress(Address Address){
        if(AddressRepository.existsById(Address.getId())){
            AddressRepository.save(Address);
        }
    }
    
}

