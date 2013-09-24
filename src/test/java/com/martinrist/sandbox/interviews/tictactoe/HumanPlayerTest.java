package com.martinrist.sandbox.interviews.tictactoe;

import static com.martinrist.sandbox.interviews.tictactoe.Counter.X;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HumanPlayerTest {

	@Test
	public void testCreateNamedXHumanPlayer() {
		Player player1 = new HumanPlayer("player1", X);
		assertEquals("player1", player1.getName());
		assertEquals(X, player1.getCounter());
	}

}
