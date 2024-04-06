package com.macedo.ecommerce.model;

import java.util.List;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;



// representa uma compra
public class Purchase {
    private int id;
    private User user;
    private List<ProductItem> productItems;
    private BigDecimal totalPrice;
    private Payment payment;
    private Address address;


    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date date;
}
