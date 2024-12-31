package com.example.tech_service.repository;

import com.example.tech_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUserName(String userName);


    }
