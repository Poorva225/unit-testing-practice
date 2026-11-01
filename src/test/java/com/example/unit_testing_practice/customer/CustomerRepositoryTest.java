
package com.example.unit_testing_practice.customer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    // Test 1: Save and find customer
    @Test
    void shouldSaveAndFindCustomer() {

        // Arrange
        Customer customer = new Customer("Rahul");

        // Act
        Customer savedCustomer = customerRepository.save(customer);

        // Assert
        assertNotNull(savedCustomer.getId());
        assertEquals("Rahul", savedCustomer.getName());

        Optional<Customer> result =
                customerRepository.findById(savedCustomer.getId());

        assertTrue(result.isPresent());
        assertEquals("Rahul", result.get().getName());
    }

    // Test 2: Find all customers
    @Test
    void shouldReturnAllCustomers() {

        // Arrange
        customerRepository.save(new Customer("Rahul"));
        customerRepository.save(new Customer("Poorva"));

        // Act
        var customers = customerRepository.findAll();

        // Assert
        assertEquals(2, customers.size());
    }

    // Test 3: Check customer exists
    @Test
    void shouldCheckCustomerExists() {

        // Arrange
        Customer savedCustomer =
                customerRepository.save(new Customer("Rahul"));

        // Act
        boolean exists =
                customerRepository.existsById(savedCustomer.getId());

        // Assert
        assertTrue(exists);
    }

    // Test 4: Delete customer
    @Test
    void shouldDeleteCustomerById() {

        // Arrange
        Customer savedCustomer =
                customerRepository.save(new Customer("Rahul"));

        Long customerId = savedCustomer.getId();

        // Act
        customerRepository.deleteById(customerId);

        // Assert
        assertFalse(customerRepository.existsById(customerId));
    }
}
