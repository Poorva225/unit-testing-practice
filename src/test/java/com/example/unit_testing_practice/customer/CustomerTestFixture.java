package com.example.unit_testing_practice.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestFixture {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = CustomerFixtureTest.createCustomer();
    }

    @Test
    void shouldReturnCustomerName() {
        assertEquals("Poorva", customer.getName());
    }

    @Test
    void shouldReturnCustomerId() {
        assertEquals(1L, customer.getId());
    }
}