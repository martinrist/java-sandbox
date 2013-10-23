package com.martinrist.sandbox.lang.generics;

public class Pair<T extends Comparable<? super T>> {

	private T first;
	private T second;

	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}

	@SafeVarargs
	public static <T extends Comparable<T>> Pair<T> fromFirstArguments(T... args) {
		T first = args[0];
		T second = args[1];
		return new Pair<T>(first, second);
	}

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	/**
	 * Returns the larger of the two members of the pair, based on their natural ordering.
	 * 
	 * @return The larger of the two members, or the first member if equal.
	 */
	public T getLarger() {
		if (first.compareTo(second) >= 0) {
			return first;
		} else {
			return second;
		}
	}

	/**
	 * Returns the smaller of the two members of the pair, based on their natural ordering.
	 * 
	 * @return The smaller of the two members, or the first member if equal.
	 */
	public T getSmaller() {
		if (first.compareTo(second) <= 0) {
			return first;
		} else {
			return second;
		}
	}

}
