package com.martinrist.sandbox.interviews.tictactoe.exception;


public class TooManyPlayersException extends GameException {

	private static final long serialVersionUID = 1L;

	public TooManyPlayersException() {
		super();
	}

	public TooManyPlayersException(String message) {
		super(message);
	}

}
