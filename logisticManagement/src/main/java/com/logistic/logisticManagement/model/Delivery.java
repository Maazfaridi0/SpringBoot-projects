package com.logistic.logisticManagement.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private String route;
    private double trafficScore;
    private LocalDate deliveryTime;

    // Constructors
    public Delivery() {}

    public Delivery(Order order, String route, double trafficScore, LocalDate deliveryTime) {
        this.order = order;
        this.route = route;
        this.trafficScore = trafficScore;
        this.deliveryTime = deliveryTime;
    }

    // Getters and Setters
    public Long getDeliveryId() { return deliveryId; }
    public void setDeliveryId(Long deliveryId) { this.deliveryId = deliveryId; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public String getRoute() { return route; }
    public void setRoute(String route) { this.route = route; }

    public double getTrafficScore() { return trafficScore; }
    public void setTrafficScore(double trafficScore) { this.trafficScore = trafficScore; }

    public LocalDate getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime(LocalDate deliveryTime) { this.deliveryTime = deliveryTime; }
}
