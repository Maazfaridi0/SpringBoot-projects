package com.logistic.logisticManagement.controller;

import com.logistic.logisticManagement.model.Delivery;
import com.logistic.logisticManagement.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    // Create a new delivery
    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery createdDelivery = deliveryService.saveDelivery(delivery);
        return new ResponseEntity<>(createdDelivery, HttpStatus.CREATED);
    }

    // Get all deliveries
    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return new ResponseEntity<>(deliveries, HttpStatus.OK);
    }

    // Get delivery by ID
    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Long id) {
        Optional<Delivery> delivery = deliveryService.getDeliveryById(id);
        return delivery.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update a delivery
    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable("id") Long id, @RequestBody Delivery delivery) {
        Optional<Delivery> existingDelivery = deliveryService.getDeliveryById(id);
        if (existingDelivery.isPresent()) {
            delivery.setDeliveryId(id);
            Delivery updatedDelivery = deliveryService.saveDelivery(delivery);
            return new ResponseEntity<>(updatedDelivery, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete a delivery
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable("id") Long id) {
        if (deliveryService.deleteDelivery(id)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
