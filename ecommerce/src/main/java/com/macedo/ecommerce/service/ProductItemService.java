package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.ProductItem;
import com.macedo.ecommerce.repository.ProductItemRepository;

@Component
public class ProductItemService {

    @Autowired
    ProductItemRepository ProductItemRepository;

    public List<ProductItem> getProductItems(){
        return ProductItemRepository.findAll();
    }

    public ProductItem getProductItemById(Integer id){
        return ProductItemRepository.findById(id).map(ProductItem -> {
            return ProductItem;
        }).orElseThrow(() -> null);
    }

    public void saveProductItem(ProductItem ProductItem){
        ProductItemRepository.save(ProductItem);
    }

    public void deleteProductItem(ProductItem ProductItem){
        ProductItemRepository.delete(ProductItem);
    }

    public void updateProductItem(ProductItem ProductItem){
        if(ProductItemRepository.existsById(ProductItem.getId())){
            ProductItemRepository.save(ProductItem);
        }
    }
    
}
