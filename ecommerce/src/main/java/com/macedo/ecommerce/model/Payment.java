package com.macedo.ecommerce.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private PaymentMethod paymentMethod;
    private CreditCard creditCard; //armazena se o pagamento tiver sido como cartão de credito;
    private int installments; //quantidade de parcelas de um pagamento
    private BigDecimal price;

}
