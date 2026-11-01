package com.example.unit_testing_practice.customer;

public class CustomerFixtureTest {

    public static Customer createCustomer() {
        return new Customer(1L, "Poorva");
    }

    public static Customer createAnotherCustomer() {
        return new Customer(2L, "Rahul");
    }
}