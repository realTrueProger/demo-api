package com.isollo.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class DemoApiApplication {
	//db
	private static ArrayList<Customer> customers;

	static {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "Vova", "vova@mail.ru"));
		customers.add(new Customer(2, "Dima", "dima@mail.ru"));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customers;
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable("id") Integer id) {
		return customers
				.stream()
				.filter(customer -> customer.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Customer with id getCustomers" + id + " not found"));
	}

	static class Customer {
		private Integer id;
		private String name;
		private String email;

		public Customer() {
		}

		public Customer(Integer id, String name, String email) {
			this.id = id;
			this.name = name;
			this.email = email;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Customer customer = (Customer) o;
			return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, name, email);
		}

		@Override
		public String toString() {
			return "Customer{" +
					"id=" + id +
					", name='" + name + '\'' +
					", email='" + email + '\'' +
					'}';
		}
	}

}
