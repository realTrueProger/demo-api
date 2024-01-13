package com.isollo.demoapi.customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerDao {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomer(Integer id);
    void insertCustomer(Customer customer);
    boolean existCustomerWithEmail(String email);
}
