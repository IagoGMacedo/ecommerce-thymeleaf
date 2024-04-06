package com.macedo.ecommerce.model;

import java.math.BigDecimal;

public class Payment {
    private int id;
    private PaymentMethod paymentMethod;
    private CreditCard creditCard; //armazena se o pagamento tiver sido como cartão de credito;
    private int installments; //quantidade de parcelas de um pagamento
    private BigDecimal price;

}
