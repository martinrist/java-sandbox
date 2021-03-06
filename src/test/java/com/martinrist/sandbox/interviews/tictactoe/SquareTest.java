package com.martinrist.sandbox.interviews.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {

	private Square square;

	@Before
	public void setUp() throws Exception {
		square = new Square();
	}

	@Test
	public void testNewSquareIsNotFilled() {
		assertFalse(square.isFilled());
	}

	@Test
	public void testPlacingCounterMakesASquareFilled() {
		square.setCounter(Counter.X);
		assertTrue(square.isFilled());
	}

	@Test
	public void testCanRetrievePreviouslyPlacedCounter() {
		square.setCounter(Counter.X);
		assertEquals(Counter.X, square.getCounter());
	}

	@Test
	public void testCanPlaceNewCounterOverExisting() {
		square.setCounter(Counter.X);
		square.setCounter(Counter.O);
		assertEquals(Counter.O, square.getCounter());
	}

}
