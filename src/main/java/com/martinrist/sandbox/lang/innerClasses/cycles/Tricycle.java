package com.martinrist.sandbox.lang.innerClasses.cycles;

public class Tricycle implements Cycle {

	private Tricycle() {
		// Enforce non-instantiability through private constructor
	}

	@Override
	public int getNumberOfWheels() {
		return 3;
	}

	public static CycleFactory factory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Tricycle();
		}
	};
}
