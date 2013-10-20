package com.martinrist.sandbox.lang.generics;

class Base implements Comparable<Base> {

	private final int value;

	public static Base instanceOf(int value) {
		return new Base(value);
	}

	public Base(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Base other = (Base) obj;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public int compareTo(Base o) {
		if (o == null)
			throw new IllegalArgumentException("Cannot compare to a null instance");

		if (this.value < o.value) {
			return -1;
		} else if (this.value > o.value) {
			return 1;
		} else {
			return 0;
		}
	}
}