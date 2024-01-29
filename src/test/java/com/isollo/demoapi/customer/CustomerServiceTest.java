package com.isollo.demoapi.customer;

import com.isollo.demoapi.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

class CustomerServiceTest {
    private CustomerService underTest;

    @Mock
    private ICustomerDao customerDao = mock();

    @BeforeEach
    void setUp() {
        this.underTest = new CustomerService(customerDao);
    }

    @Test
    void itShouldGetAllCustomers() {
        underTest.getAllCustomers();
        verify(customerDao).getAllCustomers();
    }

    @Test
    void itShouldThrowAtGetCustomer() {
        assertThatThrownBy(() -> underTest.getCustomer(1))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void itShouldAddCustomer() {
        CustomerRegistrationRequest customerRegistrationRequest =
                new CustomerRegistrationRequest("Vova", "vova@mail.ru");

        underTest.addCustomer(customerRegistrationRequest);

        ArgumentCaptor<CustomerRegistrationRequest> customerRegistrationRequestArgumentCaptor =
                ArgumentCaptor.forClass(CustomerRegistrationRequest.class);

    }

    @Test
    void itShouldThrowAtDeleteCustomer() {
        when(customerDao.existCustomerWithId(1)).thenReturn(false);
        assertThatThrownBy(() -> underTest.deleteCustomer(1))
                .isInstanceOf(ResourceNotFoundException.class);
    }

    @Test
    void itShouldDeleteCustomer() {
        when(customerDao.existCustomerWithId(1)).thenReturn(true);
        underTest.deleteCustomer(1);
        verify(customerDao).deleteCustomer(1);
    }

    @Test
    void itShouldUpdateCustomer() {


    }

    @Test
    void itShouldCheckEmailException() {


    }
}