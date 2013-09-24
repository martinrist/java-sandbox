package com.martinrist.sandbox.interviews.tictactoe.exception;


public class CounterAlreadyUsedException extends GameException {

	private static final long serialVersionUID = 1L;

	public CounterAlreadyUsedException() {
		super();
	}

	public CounterAlreadyUsedException(String message) {
		super(message);
	}

}
