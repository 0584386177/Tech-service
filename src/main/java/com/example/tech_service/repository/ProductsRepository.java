package com.example.tech_service.repository;

import com.example.tech_service.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {


}
