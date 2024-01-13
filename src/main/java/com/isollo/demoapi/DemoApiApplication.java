package com.isollo.demoapi;

import com.isollo.demoapi.customer.Customer;
import com.isollo.demoapi.customer.ICustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (ICustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer( "Vova", "vova@mail.ru"));
			customerRepository.save(new Customer( "Dima", "dima@mail.ru"));
		};
	}
}
