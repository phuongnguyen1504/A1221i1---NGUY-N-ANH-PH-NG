package com.example.customer_management.configuration;

import com.example.customer_management.service.CustomerService;
import com.example.customer_management.service.Impl.SimpleCustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {
    @Bean
    public CustomerService customerService() {
        return new SimpleCustomerServiceImpl();
    }
}
