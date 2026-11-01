package com.example.testing;
import org.springframework.stereotype.*;

@Service
public class CalculatorService {

	public int add(int a , int b) {
		return a+b;
	}
	public boolean isPositive(int number) {
		return number >0;
	}
	public int divide(int a , int b) {
		if(b==0) {
			throw new IllegalArgumentException("Divisor cannot be zero");
		}
		return a/b;
		}
	}

