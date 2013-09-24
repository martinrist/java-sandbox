package com.martinrist.sandbox.interviews.tictactoe;

public class AbstractPlayer implements Player {

	private final String name;
	private final Counter counter;

	public AbstractPlayer(String name, Counter counter) {
		this.name = name;
		this.counter = counter;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Counter getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return name + " (" + counter + ")";
	}

}
