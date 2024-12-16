package com.example.laptop_stores.models;

import jakarta.persistence.*;
import java.text.DecimalFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "computer_infor")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String name;
    private String image;
    private BigDecimal price;
    private BigDecimal sale;

    public Product() {
    }

    public Product(int id, String description, String name, String image, BigDecimal price, BigDecimal sale) {
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
    public String getFormattedPrice() {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(price) + " VND";
    }
    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }
}
