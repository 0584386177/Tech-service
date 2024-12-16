package com.example.laptop_stores.services;

import com.example.laptop_stores.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {


}
