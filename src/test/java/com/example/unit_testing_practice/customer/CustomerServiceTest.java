package com.example.unit_testing_practice.customer;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unit_testing_practice.customer.Customer;
import com.example.unit_testing_practice.customer.CustomerRepository;
import com.example.unit_testing_practice.customer.CustomerService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldReturnCustomerById() {

        Customer customer = new Customer(1L, "Rahul");
        when(customerRepository.findById(1L))
                .thenReturn(Optional.of(customer));
        Customer result = customerService.getCustomerById(1L);
        assertEquals(1L, result.getId());
        assertEquals("Rahul", result.getName());
    }
    
    @Test
    void shouldThrowExceptionWhenCustomerNotFound() {
    	when(customerRepository.findById(99L))
    	.thenReturn(Optional.empty());
    	
    	CustomerNotFoundException exception = assertThrows(
    			CustomerNotFoundException.class,
    			() -> customerService.getCustomerById(99L));
    	
    	assertEquals(
    		    "Customer not found with ID: 99",
    		    exception.getMessage()
    		);
    	verify(customerRepository).findById(99L);
    }
    
    
    @Test
    void ShouldHandleRepositoryFailure() {
    	//arrange
    	when(customerRepository.findById(1L))
    	.thenThrow(new RuntimeException("Database unavailable"));
    	//act & assert
    	RuntimeException exception = assertThrows(
    		RuntimeException.class,
    		() -> customerService.getCustomerById(1L));
    		assertEquals("Database unavailable", exception.getMessage());
    		verify(customerRepository).findById(1L);
    	}
    
    
    @Test
    void shouldThrowExceptionForNegativeCustomerId() {
    	IllegalArgumentException exception = assertThrows(
    		IllegalArgumentException.class,
    		() -> customerService.getCustomerById(-5L));
    	assertEquals(
    		    "Customer ID must be positive",
    		    exception.getMessage()
    		);    	verifyNoInteractions(customerRepository);
    	}
    
@Test
void shouldThrowExceptionForNullCustomerId() {

    // Act and Assert
    IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> customerService.getCustomerById(null)
    );

    assertEquals(
            "Customer ID must be positive",
            exception.getMessage()
    );

    verifyNoInteractions(customerRepository);
}
@Test
void shouldCaptureCustomerPassedToRepository() {

    // Arrange
    Customer customer = new Customer("Poorva");

    ArgumentCaptor<Customer> captor =
            ArgumentCaptor.forClass(Customer.class);

    // Act
    customerService.createCustomer(customer);

    // Assert
    verify(customerRepository).save(captor.capture());

    Customer capturedCustomer = captor.getValue();

    assertEquals("Poorva", capturedCustomer.getName());
}

    }
