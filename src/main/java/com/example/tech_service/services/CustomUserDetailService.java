package com.example.tech_service.services;

import com.example.tech_service.controllers.User_Role;
import com.example.tech_service.models.CustomUserDetails;
import com.example.tech_service.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userService.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("SAI");

        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<User_Role> roles = user.getUserRoles();
        for(User_Role role : roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getRole().getName()));
        }
        return new CustomUserDetails(user, grantedAuthoritySet);
    }
}
