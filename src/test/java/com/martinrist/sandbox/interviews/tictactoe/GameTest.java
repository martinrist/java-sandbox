package com.martinrist.sandbox.interviews.tictactoe;

import static com.martinrist.sandbox.interviews.tictactoe.Counter.O;
import static com.martinrist.sandbox.interviews.tictactoe.Counter.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.martinrist.sandbox.interviews.tictactoe.exception.CounterAlreadyUsedException;
import com.martinrist.sandbox.interviews.tictactoe.exception.NotYourTurnException;
import com.martinrist.sandbox.interviews.tictactoe.exception.SquareAlreadyFilledException;
import com.martinrist.sandbox.interviews.tictactoe.exception.TooManyPlayersException;

public class GameTest {

	private Game game;
	private Player player1X;
	private Player player2O;

	@Before
	public void setUp() {
		game = new Game();
		player1X = new HumanPlayer("player1", X);
		player2O = new HumanPlayer("player2", O);
	}

	@Test
	public void testCreateNewGame() {
		assertNotNull(game);
	}

	@Test
	public void testAddHumanXPlayer() {
		game.addPlayer(player1X);
		assertEquals(1, game.getNumberOfPlayers());
		assertTrue(game.getPlayers().contains(player1X));
	}

	@Test
	public void testAddTwoHumanPlayersWithDifferentCounters() {
		setupInitialGame();

		assertEquals(2, game.getNumberOfPlayers());
		assertTrue(game.getPlayers().contains(player1X));
		assertTrue(game.getPlayers().contains(player2O));
	}

	@Test
	public void testAddTwoHumanPlayersWithSameCounter() {
		game.addPlayer(player1X);
		Player player2X = new HumanPlayer("player2", X);

		try {
			game.addPlayer(player2X);
			fail("Should have thrown an exception");
		} catch (CounterAlreadyUsedException caue) {
			assertEquals(1, game.getNumberOfPlayers());
			assertTrue(game.getPlayers().contains(player1X));
			assertFalse(game.getPlayers().contains(player2X));
		}
	}

	@Test
	public void testAddFirstPlayerAndAssignCounter() {
		game.addHumanPlayer("player1");
		assertEquals(1, game.getNumberOfPlayers());

		Player player1 = game.getPlayers().get(0);
		assertNotNull(game.getPlayers().get(0));
		assertEquals("player1", player1.getName());

		assertEquals(X, player1.getCounter());
	}

	@Test
	public void testAddTwoPlayersAndAssignCounters() {
		game.addHumanPlayer("player1");
		game.addHumanPlayer("player2");

		assertEquals(2, game.getNumberOfPlayers());

		Player player1 = game.getPlayers().get(0);
		assertEquals("player1", player1.getName());
		assertEquals(X, player1.getCounter());

		Player player2 = game.getPlayers().get(1);
		assertEquals("player2", player2.getName());
		assertEquals(O, player2.getCounter());

	}

	@Test
	public void testAddThreePlayersThrowsException() {
		setupInitialGame();

		try {
			game.addHumanPlayer("player3");
		} catch (TooManyPlayersException tmpe) {
			assertEquals(2, game.getNumberOfPlayers());
		}
	}

	@Test
	public void testPlayer1GoesFirst() {
		setupInitialGame();
		assertEquals(player1X, game.getCurrentPlayer());
	}

	@Test
	public void testPlayer2FollowsPlayer1() {
		setupInitialGame();
		game.makeMove(player1X, 1, 1);
		assertEquals(player2O, game.getCurrentPlayer());
	}

	@Test
	public void testPlayer1FollowsPlayer2() {
		setupInitialGame();
		game.makeMove(player1X, 1, 1);
		game.makeMove(player2O, 2, 2);
		assertEquals(player1X, game.getCurrentPlayer());
	}

	@Test
	public void testPlayer2CantGoOnPlayer1sTurn() {
		setupInitialGame();
		try {
			game.makeMove(player2O, 1, 1);
			fail("Expected NotYourTurnException was not thrown");
		} catch (NotYourTurnException nyte) {
			// Expected result
		}
	}

	@Test
	public void testPlayer1CantGoOnPlayer2sTurn() {
		setupInitialGame();
		game.makeMove(player1X, 1, 1);
		game.makeMove(player2O, 2, 2);
		try {
			game.makeMove(player2O, 1, 2);
			fail("Expected NotYourTurnException was not thrown");
		} catch (NotYourTurnException nyte) {
			// Expected result
		}
	}

	@Test
	public void testIfSquareNotFilledMoveIsValid() throws Exception {
		assertTrue(game.isMoveValid(1, 1));
	}

	@Test
	public void testIfSquareFilledMoveIsNotValid() throws Exception {
		setupInitialGame();
		game.makeMove(player1X, 1, 1);
		assertFalse(game.isMoveValid(1, 1));
	}

	private void setupInitialGame() {
		game.addPlayer(player1X);
		game.addPlayer(player2O);
	}
}
