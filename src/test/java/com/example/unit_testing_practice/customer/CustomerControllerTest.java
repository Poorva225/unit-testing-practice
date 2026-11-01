package com.example.unit_testing_practice.customer;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerService customerService;

    @Test
    void shouldReturnCustomerById() throws Exception {

        // Arrange: Mock service response
        Customer customer = new Customer(1L, "Rahul");

        when(customerService.getCustomerById(1L))
                .thenReturn(customer);

        // Act + Assert: Perform GET request and verify response
        mockMvc.perform(get("/api/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Rahul"));
    }
    @Test
    void shouldReturn404WhenCustomerNotFound() throws Exception {

        when(customerService.getCustomerById(99L))
                .thenThrow(new CustomerNotFoundException(
                        "Customer not found with ID: 99"));

        mockMvc.perform(get("/api/customers/99"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(
                        "Customer not found with ID: 99"));
    }
}