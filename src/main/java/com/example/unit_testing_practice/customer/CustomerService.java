
package com.example.unit_testing_practice.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    

    public Customer getCustomerById(Long id) {
    	
    	if(id==null || id<=0) {
    		 throw new IllegalArgumentException("Customer ID must be positive");
    	}
        return customerRepository.findById(id)
                .orElseThrow(() ->
                    new CustomerNotFoundException(
                        "Customer not found with ID: " + id
                    ));
    }
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
