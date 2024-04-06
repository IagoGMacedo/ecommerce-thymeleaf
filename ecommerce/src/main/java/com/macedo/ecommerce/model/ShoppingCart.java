package com.macedo.ecommerce.model;

import java.util.List;
import java.math.BigDecimal;


public class ShoppingCart {
    private int id;
    private List<ProductItem> productItems;
    private BigDecimal totalPrice;
}
