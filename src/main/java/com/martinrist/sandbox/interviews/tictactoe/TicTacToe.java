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

	public static void main(String[] args) {
		new TicTacToe().play();
	}

	private void play() {
		createPlayers();
		outputCurrentGameState();
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

	private String getPlayerName(int playerNumber) {

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
