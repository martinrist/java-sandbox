package com.martinrist.sandbox.interviews.tictactoe;

import java.util.ArrayList;
import java.util.List;

import com.martinrist.sandbox.interviews.tictactoe.exception.CounterAlreadyUsedException;
import com.martinrist.sandbox.interviews.tictactoe.exception.TooManyPlayersException;

public class Game {

	private final List<Player> players = new ArrayList<>();
	private int currentPlayerIndex = 0;

	public void addHumanPlayer(String name) {

		Counter counter;
		if (players.size() == 0) {
			counter = Counter.X;
		} else {
			counter = Counter.O;
		}

		Player player = new HumanPlayer(name, counter);
		addPlayer(player);

	}

	public void addPlayer(Player player) {

		if (players.size() == 2) {
			throw new TooManyPlayersException();
		}

		Counter playerCounter = player.getCounter();

		for (Player currentPlayer : players) {
			if (currentPlayer.getCounter().equals(playerCounter)) {
				throw new CounterAlreadyUsedException(playerCounter
														+ " is already assigned to player "
														+ currentPlayer.getName());
			}
		}
		players.add(player);
	}

	public int getNumberOfPlayers() {
		return players.size();
	}

	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public String toString() {
		String result = "Players:\n";
		for (Player player : players) {
			result += "- " + player.toString() + "\n";
		}
		return result;
	}

	public Player getNextPlayer() {
		return players.get(currentPlayerIndex);
	}

	public void makeMove(Player player, int row, int column) {
		currentPlayerIndex = (currentPlayerIndex + 1) % 2;
	}
}
