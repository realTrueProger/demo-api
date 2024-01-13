package com.isollo.demoapi.customer;

import com.isollo.demoapi.exception.BadRequestException;
import com.isollo.demoapi.exception.DuplicateRecordException;
import com.isollo.demoapi.exception.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        checkEmailException(customerRegistrationRequest.email());
        customerDao.insertCustomer(new Customer(customerRegistrationRequest.name(), customerRegistrationRequest.email()));
    }

    public void deleteCustomer(Integer id) {
        if (!customerDao.existCustomerWithId(id)) {
            throw new ResourceNotFoundException("Customer not found");
        }

        customerDao.deleteCustomer(id);
    }

    public void updateCustomer(Integer id, CustomerUpdateRequest customerUpdateRequest) {
        Customer updatedCustomer = getCustomer(id);
        boolean isChanged = false;

        if (customerUpdateRequest.name() != null && !customerUpdateRequest.name().equals(updatedCustomer.getName())) {
            updatedCustomer.setName(customerUpdateRequest.name());
            isChanged = true;
        }

        if (customerUpdateRequest.email() != null && !customerUpdateRequest.email().equals(updatedCustomer.getEmail())) {
            checkEmailException(customerUpdateRequest.email());
            updatedCustomer.setEmail(customerUpdateRequest.email());
            isChanged = true;
        }

        if (!isChanged) {
            throw new BadRequestException("No changes in customer");
        }

        customerDao.updateCustomer(updatedCustomer);
    }

    public void checkEmailException(String email) {
        if (customerDao.existCustomerWithEmail(email)) {
            throw new DuplicateRecordException("Customer with such email already exists");
        }
    }
}
