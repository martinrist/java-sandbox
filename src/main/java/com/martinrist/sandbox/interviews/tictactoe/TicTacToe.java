package com.martinrist.sandbox.interviews.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class TicTacToe {

	private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private final PrintStream output = System.out;
	private final PrintStream error = System.err;

	private final Game game = new Game();

	public static void main(final String[] args) {
		new TicTacToe().play();
	}

	private void play() {
		createPlayers();

		while (!game.isBoardFull()) {
			outputCurrentGameState();
			playTurn();
		}

		output.println("Game is complete!");
		outputCurrentGameState();
	}

	private void playTurn() {

		Player player = game.getCurrentPlayer();
		output.println(player + "'s turn:");

		boolean validMove = false;
		// TODO: Can we remove these sentinel values?
		int row = -1;
		int col = -1;

		while (!validMove) {
			output.print("Enter row: (0-" + (game.getBoardSize() - 1) + ")");
			row = getValidatedRowOrColumn();
			output.print("Enter column: (0-" + (game.getBoardSize() - 1) + ")");
			col = getValidatedRowOrColumn();

			if (!game.isMoveValid(row, col)) {
				output.println("That move is not valid.  Please try another.");
			} else {
				validMove = true;
			}
		}

		game.makeMove(player, row, col);

	}

	private int getValidatedRowOrColumn() {

		boolean valid = false;

		// TODO: See if it's possible to avoid the use of this sentinel value
		int inputInteger = -1;

		while (!valid) {
			try {
				inputInteger = Integer.parseInt(input.readLine());
			} catch (IOException e) {
				output.println("There was a problem reading the value.  Please try again");
				continue;
			} catch (NumberFormatException nfe) {
				// TODO: This is using an exception to handle a typical input
				// case - is there a better way?
				output.println("Please enter a valid number");
				continue;
			}
			if (inputInteger < 0 || inputInteger >= game.getBoardSize()) {
				output.println("Please enter a number between 0 and " + (game.getBoardSize() - 1));
			} else {
				valid = true;
			}
		}

		return inputInteger;
	}

	private void outputCurrentGameState() {
		output.println(game);
	}

	private void createPlayers() {
		String player1Name = getPlayerName(1);
		game.addHumanPlayer(player1Name);
		String player2Name = getPlayerName(2);
		game.addHumanPlayer(player2Name);
	}

	private String getPlayerName(final int playerNumber) {
		output.print("Enter name for player " + playerNumber + ":");
		String name = null;
		while (name == null || "".equals(name)) {
			try {
				name = input.readLine();
			} catch (IOException e) {
				error.println("Unable to get player name.  Defaulting to Player" + playerNumber);
				name = "Player" + playerNumber;
			}
		}
		return name;
	}
}
