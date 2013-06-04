package com.martinrist.sandbox.lang.innerClasses.tossing;

import java.util.Random;

public class Coin implements Tossable {

	private final Random rand = new Random();

	private static final Result[] results = {new Result("Heads", 0), new Result("Tails", 1)};

	private Coin() {
		// Enforce non-instantiability via private constructor
	}

	@Override
	public Result toss() {
		int resultNum = rand.nextInt(results.length);
		return results[resultNum];
	}

	public static TossableFactory factory = new TossableFactory() {
		@Override
		public Tossable create() {
			return new Coin();
		}
	};

}