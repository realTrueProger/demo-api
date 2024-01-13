package com.isollo.demoapi.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Bean
    CommandLineRunner runner(ICustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(new Customer("Vova", "vova@mail.ru"));
            customerRepository.save(new Customer("Dima", "dima@mail.ru"));
        };
    }
}
