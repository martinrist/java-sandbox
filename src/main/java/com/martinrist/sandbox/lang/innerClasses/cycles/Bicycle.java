package com.martinrist.sandbox.lang.innerClasses.cycles;

public class Bicycle implements Cycle {

	private Bicycle() {
		// Enforce non-instantiability through private constructor
	}

	@Override
	public int getNumberOfWheels() {
		return 2;
	}

	public static CycleFactory factory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Bicycle();
		}
	};

}
