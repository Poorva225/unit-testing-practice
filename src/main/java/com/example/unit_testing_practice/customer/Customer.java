
package com.example.unit_testing_practice.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Required by JPA
    public Customer() {
    }

    // Constructor with ID
    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor without ID
    public Customer(String name) {
        this.name = name;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
