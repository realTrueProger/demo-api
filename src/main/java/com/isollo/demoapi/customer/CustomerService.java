package com.isollo.demoapi.customer;

import com.isollo.demoapi.exception.DuplicateRecord;
import com.isollo.demoapi.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final ICustomerDao customerDao;

    public CustomerService(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomer(Integer id) {
        return customerDao
                .getCustomer(id)
                .orElseThrow(() -> new ResourceNotFound("Customer not found"));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        if (customerDao.existCustomerWithEmail(customerRegistrationRequest.email())) {
            throw new DuplicateRecord("Customer with such email already exists");
        }

        customerDao.insertCustomer(new Customer(customerRegistrationRequest.name(), customerRegistrationRequest.email()));
    }

    public void deleteCustomer(Integer id) {
        if(!customerDao.existCustomerWithId(id)) {
            throw new ResourceNotFound("Customer not found");
        }

        customerDao.deleteCustomer(id);
    }
}
