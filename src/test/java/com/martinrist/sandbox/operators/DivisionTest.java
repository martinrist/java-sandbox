package com.martinrist.sandbox.operators;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivisionTest {

	@Test
	public void testIntOperandsYieldIntegralDivision() {
		assertEquals(2, 5 / 2);
	}

	@Test
	public void testOneFloatOperandYieldsFloatingPointDivision() {
		assertEquals(2.5, 5 / 2.0, 0.00001);
	}
}
