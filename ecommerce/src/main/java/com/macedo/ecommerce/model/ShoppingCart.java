package com.macedo.ecommerce.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductItem> productItems;

    @Column
    private BigDecimal totalPrice;

    @OneToOne(mappedBy = "shoppingCart", fetch = FetchType.LAZY)
    private User user;

    public BigDecimal getTotalPrice(){
        BigDecimal totalValue = BigDecimal.ZERO;
        for (ProductItem products : productItems) {
            totalValue.add(products.getTotalItemPrice());
        }
        return totalValue;
    }
}
