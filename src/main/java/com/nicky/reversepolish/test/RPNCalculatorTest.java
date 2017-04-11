package com.nicky.reversepolish.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.nicky.reversepolish.RPNCalculator;
import com.nicky.reversepolish.RPNCalculatorImpl;

public class RPNCalculatorTest {
	private RPNCalculator calculator;

	@Before
	public void setup() throws Exception {
		System.setProperty("soeid", "lq00863");
		calculator = new RPNCalculatorImpl();
	}

	@Test
	public void calcSingleFunction() {
		assertEquals(calculator.calculate("-12 / 3"), -4);
	}

	@Test
	public void calcComplexFunction() {
		assertEquals(calculator.calculate("5 * ( 3 + 2 ) - 6 / ( 3 - 1 )"), 22);
	}
}
