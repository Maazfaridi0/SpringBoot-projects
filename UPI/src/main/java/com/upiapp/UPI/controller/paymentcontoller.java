package com.upiapp.UPI.controller;
import com.upiapp.UPI.model.paymentrequest;
import com.upiapp.UPI.service.paymentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/upi")
public class paymentcontoller {
    @Autowired
    private  paymentservice PaymentService;

    @PostMapping("/pay")
    public String makePayment(@RequestBody paymentrequest request){
        return PaymentService.processpayment(request);

    }



}
