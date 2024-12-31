package com.example.tech_service.services;

import com.example.tech_service.models.User;

import java.util.List;

public interface UserService {
    List<User> findByUserName(String userName);
}
