package com.example.unit_testing_practice.customer;

public class CustomerNotFoundException extends RuntimeException{
public CustomerNotFoundException(String message) {
	super(message);
}
}
