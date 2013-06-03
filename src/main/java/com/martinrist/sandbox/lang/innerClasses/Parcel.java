package com.martinrist.sandbox.lang.innerClasses;

public class Parcel {

	public class Contents {
		private final int i = 11;

		public int value() {
			return i;
		}
	}

	public class Destination {
		private final String label;

		public Destination(String whereTo) {
			this.label = whereTo;
		}

		public String getLabel() {
			return this.label;
		}
	}

	public Destination to(String s) {
		return new Destination(s);
	}

	public Contents contents() {
		return new Contents();
	}

}
