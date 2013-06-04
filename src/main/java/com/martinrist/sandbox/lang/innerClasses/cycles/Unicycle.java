package com.martinrist.sandbox.lang.innerClasses.cycles;

public class Unicycle implements Cycle {

	private Unicycle() {
		// Enforce non-instantiability through private constructor
	}

	@Override
	public int getNumberOfWheels() {
		return 1;
	}

	public static CycleFactory factory = new CycleFactory() {

		@Override
		public Cycle getCycle() {
			return new Unicycle();
		}
	};

}
