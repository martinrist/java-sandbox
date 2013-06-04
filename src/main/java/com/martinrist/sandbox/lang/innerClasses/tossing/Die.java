package com.martinrist.sandbox.lang.innerClasses.tossing;

public class Die implements Tossable {

	private Die() {
		// Enforce non-instantiability via private constructor
	}

	@Override
	public Result toss() {
		return null;
	}
}
