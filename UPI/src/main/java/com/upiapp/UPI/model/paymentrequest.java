package com.upiapp.UPI.model;

import lombok.Data;

@Data
public class paymentrequest {
    private String upiId;
    private double amount;
    private String pin;

}
