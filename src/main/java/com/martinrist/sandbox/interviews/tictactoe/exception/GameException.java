package com.martinrist.sandbox.interviews.tictactoe.exception;

public class GameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GameException() {
		super();
	}

	public GameException(String message) {
		super(message);
	}

}
