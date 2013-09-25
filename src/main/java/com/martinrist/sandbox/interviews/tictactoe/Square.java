package com.martinrist.sandbox.interviews.tictactoe;

public class Square {

	private boolean filled;
	private Counter counter;

	public boolean isFilled() {
		return filled;
	}

	public void placeCounter(final Counter counter) {
		filled = true;
		this.counter = counter;
	}

	public Counter getCounter() {
		return counter;
	}

}
