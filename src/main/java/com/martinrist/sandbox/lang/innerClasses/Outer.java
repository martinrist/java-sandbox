package com.martinrist.sandbox.lang.innerClasses;

public class Outer {

	private final String name;

	public Outer() {
		this("anon");
	}

	public Outer(String name) {
		this.name = name;
	}

	public class Inner {

		public int innerField;

		public Outer getOuter() {
			return Outer.this;
		}

		public Inner getThis() {
			return this;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public Inner inner() {
		return new Inner();
	}

}
