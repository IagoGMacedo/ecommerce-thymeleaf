package com.macedo.ecommerce.model;

import java.util.List;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String cep;
    @Column
    private String completeAddress; //endereco
    @Column
    private String number;
    @Column
    private String complement;
    @Column
    private String district; //bairro
    @Column
    private String city;
    @Column
    private String state; 

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "address")
    private List<Purchase> purchases;
}
