package com.martinrist.sandbox.interviews.tictactoe;

import java.util.ArrayList;
import java.util.List;

import com.martinrist.sandbox.interviews.tictactoe.exception.CounterAlreadyUsedException;
import com.martinrist.sandbox.interviews.tictactoe.exception.NotYourTurnException;
import com.martinrist.sandbox.interviews.tictactoe.exception.TooManyPlayersException;

public class Game {

	private static final int BOARD_SIZE = 3;
	private static final int NUMBER_OF_PLAYERS = 2;
	private final List<Player> players = new ArrayList<>();
	private int currentPlayerIndex = 0;
	private final Board board = new Board(BOARD_SIZE);

	public void addHumanPlayer(final String name) {
		validateNumberOfPlayersBeforeAddingNewPlayer();
		Counter counter = Counter.values()[players.size()];
		Player player = new HumanPlayer(name, counter);
		addPlayer(player);
	}

	public void addPlayer(final Player player) {

		validateNumberOfPlayersBeforeAddingNewPlayer();

		Counter playerCounter = player.getCounter();
		for (Player currentPlayer : players) {
			if (currentPlayer.getCounter().equals(playerCounter)) {
				throw new CounterAlreadyUsedException(playerCounter + " is already assigned to player "
						+ currentPlayer.getName());
			}
		}

		players.add(player);
	}

	private void validateNumberOfPlayersBeforeAddingNewPlayer() {
		if (getNumberOfPlayers() == NUMBER_OF_PLAYERS) {
			throw new TooManyPlayersException();
		}
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
		result += getBoard().toString();
		return result;
	}

	public Player getCurrentPlayer() {
		return players.get(currentPlayerIndex);
	}

	public void makeMove(final Player player, final int row, final int column) {
		if (!player.equals(getCurrentPlayer())) {
			throw new NotYourTurnException();
		}
		board.placeCounter(player.getCounter(), row, column);
		advanceToNextPlayer();
	}

	private void advanceToNextPlayer() {
		currentPlayerIndex = (currentPlayerIndex + 1) % NUMBER_OF_PLAYERS;
	}

	public boolean isBoardFull() {
		return getBoard().isFull();
	}

	public int getBoardSize() {
		return getBoard().getSize();
	}

	// TODO: Not sure I'm happy about the game leaking its board out. We'll end
	// up with LoD violations in the clients
	public Board getBoard() {
		return board;
	}
}