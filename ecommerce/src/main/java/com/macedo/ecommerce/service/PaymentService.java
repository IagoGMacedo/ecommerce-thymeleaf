package com.macedo.ecommerce.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.macedo.ecommerce.model.Payment;
import com.macedo.ecommerce.repository.PaymentRepository;

@Component
public class PaymentService {

    @Autowired
    PaymentRepository PaymentRepository;

    public List<Payment> getPayments(){
        return PaymentRepository.findAll();
    }

    public Payment getPaymentById(Integer id){
        return PaymentRepository.findById(id).map(Payment -> {
            return Payment;
        }).orElseThrow(() -> null);
    }

    public void savePayment(Payment Payment){
        PaymentRepository.save(Payment);
    }

    public void deletePayment(Payment Payment){
        PaymentRepository.delete(Payment);
    }

    public void updatePayment(Payment Payment){
        if(PaymentRepository.existsById(Payment.getId())){
            PaymentRepository.save(Payment);
        }
    }
    
}

