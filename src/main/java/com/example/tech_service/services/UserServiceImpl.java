package com.example.tech_service.services;
import com.example.tech_service.models.User;
import com.example.tech_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);

    }

}
