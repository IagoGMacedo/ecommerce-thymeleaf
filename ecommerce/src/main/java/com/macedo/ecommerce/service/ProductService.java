package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.Product;
import com.macedo.ecommerce.repository.ProductRepository;

@Component
public class ProductService {

    @Autowired
    ProductRepository ProductRepository;

    public List<Product> getProducts(){
        return ProductRepository.findAll();
    }

    public Product getProductById(Integer id){
        return ProductRepository.findById(id).map(Product -> {
            return Product;
        }).orElseThrow(() -> null);
    }

    public void saveProduct(Product Product){
        ProductRepository.save(Product);
    }

    public void deleteProduct(Product Product){
        ProductRepository.delete(Product);
    }

    public void updateProduct(Product Product){
        if(ProductRepository.existsById(Product.getId())){
            ProductRepository.save(Product);
        }
    }
    
}

