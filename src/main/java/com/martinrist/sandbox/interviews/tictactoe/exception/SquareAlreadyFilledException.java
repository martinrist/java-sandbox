package com.martinrist.sandbox.interviews.tictactoe.exception;


public class SquareAlreadyFilledException extends GameException {

	private static final long serialVersionUID = 1L;

	public SquareAlreadyFilledException() {
		super();
	}

	public SquareAlreadyFilledException(final String message) {
		super(message);
	}

}
