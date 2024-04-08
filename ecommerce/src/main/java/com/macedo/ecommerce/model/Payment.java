package com.macedo.ecommerce.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "creditCard_id") 
    private CreditCard creditCard; //armazena se o pagamento tiver sido como cartão de credito;

    @Column
    private int installments; //quantidade de parcelas de um pagamento

    @Column
    private BigDecimal price;

}
