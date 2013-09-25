package com.martinrist.sandbox.interviews.tictactoe.exception;


public class NotYourTurnException extends GameException {

	private static final long serialVersionUID = 1L;

	public NotYourTurnException() {
		super();
	}

	public NotYourTurnException(String message) {
		super(message);
	}

}
