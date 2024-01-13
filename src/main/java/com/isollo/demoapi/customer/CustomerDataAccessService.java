package com.isollo.demoapi.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("List")
public class CustomerDataAccessService implements ICustomerDao {
    //db
    private static final ArrayList<Customer> customers;

    static {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "Vova", "vova@mail.ru"));
        customers.add(new Customer(2, "Dima", "dima@mail.ru"));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> getCustomer(Integer id) {
        return customers
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
}
