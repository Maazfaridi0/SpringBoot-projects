package com.upiapp.UPI.service;

import org.springframework.stereotype.Service;

import com.upiapp.UPI.model.paymentrequest;

@Service
public class paymentservice {
    public String processpayment(paymentrequest request) {
        if (!"1234".equals(request.getPin())) {
            return "Invalid pin";
        }
        return "Payment successful" + request.getAmount() + "to" + request.getUpiId() + "is successful";
    }

}
