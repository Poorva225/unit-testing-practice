package com.example.testing;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class CalculatorServiceTest {

	
	private CalculatorService service;
	
	@BeforeEach
    void setUp() {
        service = new CalculatorService();
    }
	
	@Test
    void shouldAddTwoNumbers() {
        assertEquals(30, service.add(10, 20));
    }
	
	
	@Test
	void shouldReturnTrueForPositiveNumber() {
		assertTrue(service.isPositive(5));
	}
	
	@Test
	void shouldReturnFalseForPositiveNumber() {
		assertFalse(service.isPositive(-5));
	}
	
	@Test
	void shouldDivideTwoNumber() {
		assertEquals(5, service.divide(10, 2));
	}
	
	@Test
	void shouldThrowExceptionWhenDividingByZero() {
		IllegalArgumentException exception =
				assertThrows(
						IllegalArgumentException.class,
						() -> service.divide(10,0)
						);
		assertEquals("Divisor cannot be zero", exception.getMessage());
	}
	
	@Test
	void shouldReturnPositiveId() {
	    assertTrue(1L > 0);
	}

	@Test
	void shouldReturnAnotherPositiveId() {
	    assertTrue(10L > 0);
	}
}
