package com.macedo.ecommerce.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;

    /* 
        @ManyToOne
        @JoinColumn(name = "category_id") 
    */
    @Enumerated
    private Category category;

    @Column
    private int  stockQuantity;

    // preciso disso mesmo? não vou usar pra nada mas preciso botar aqui?
    @OneToMany(mappedBy = "product") // acho que não preciso de nenhum fetch
    private List<ProductItem> productItems;
}
