
package com.example.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorSpyTest {

    @Spy
    Calculator calculator = new Calculator();

    @Test
    void shouldCallRealMethod() {

        int result = calculator.add(10, 20);

        assertEquals(30, result);

        verify(calculator).add(10, 20);
    }

    @Test
    void shouldMockSpecificMethod() {

        doReturn(100).when(calculator).multiply(5, 5);

        int result = calculator.multiply(5, 5);

        assertEquals(100, result);
    }
}
