package com.example.tech_service.models;

import jakarta.persistence.*;
import java.text.DecimalFormat;

import java.math.BigDecimal;

@Entity
@Table(name = "computer_infor")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String name;
    private String image;
    @Column(precision = 20, scale = 2)  // Định nghĩa độ chính xác và số chữ số sau dấu phẩy
    private BigDecimal price;
    private double sale;

    public Product() {
    }

    public Product(int id, String description, String name, String image, BigDecimal price, double sale) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.image = image;
        this.price = price;
        this.sale = sale;
    }

    //và các getter/setter của các thuộc tính


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }
}
