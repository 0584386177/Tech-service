package com.example.tech_service.config;

import com.example.tech_service.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private CustomUserDetailService customUserDetailService;
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/*").permitAll()
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login") // URL phải bắt đầu bằng "/"
                        .loginProcessingUrl("/login") // URL xử lý đăng nhập
                        .usernameParameter("username") // Tên tham số cho username
                        .passwordParameter("password") // Tên tham số cho password
                        .defaultSuccessUrl("/admin", true)); // URL chuyển hướng sau khi đăng nhập thành công
        return http.build();
    }
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return(web)-> web.debug(true).ignoring().requestMatchers("/static/**","/fe/**","/assets/**");

    }
}