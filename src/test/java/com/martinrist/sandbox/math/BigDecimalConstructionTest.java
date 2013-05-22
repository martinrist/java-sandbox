package com.martinrist.sandbox.math;

import java.math.BigDecimal;

import org.junit.Test;

import static org.junit.Assert.*;

public class BigDecimalConstructionTest {

	@Test
	public void testBigDecimalDoubleConstructorDoesntGuaranteeExactRepresentation() {
	
		BigDecimal value = new BigDecimal(0.1);
		assertNotEquals("0.1", value.toString());
	
	}
	
	@Test
	public void testBigDecimalStringConstructorGuaranteesExactRepresentation() {
	
		BigDecimal value = new BigDecimal("0.1");
		assertEquals("0.1", value.toString());
	
	}
	
	@Test
	public void testBigDecimalFactoryMethodGuaranteesExactRepresentation() {
		
		BigDecimal value = BigDecimal.valueOf(0.1);
		assertEquals("0.1", value.toString());
		
	}
	
	
}
