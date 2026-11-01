
package com.example.unit_testing_practice.customer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AdvancedTestingTest {

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 10, 100, 500})
    void shouldAcceptPositiveCustomerIds(Long id) {

        assertTrue(id > 0,
                "Customer ID must be positive");
    }
}
