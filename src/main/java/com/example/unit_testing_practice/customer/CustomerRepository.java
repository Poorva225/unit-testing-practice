package com.example.unit_testing_practice.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
extends JpaRepository<Customer, Long> {

}