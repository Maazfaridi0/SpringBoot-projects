package com.logistic.logisticManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private String category;
    private int stock;
    private double demandScore;

    // Constructors
    public Product() {}

    public Product(String name, String category, int stock, double demandScore) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.demandScore = demandScore;
    }

    // Getters and Setters
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getDemandScore() { return demandScore; }
    public void setDemandScore(double demandScore) { this.demandScore = demandScore; }
}
