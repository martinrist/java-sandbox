package com.martinrist.sandbox.lang.generics;

import java.util.Collection;

public class GenericUtilities {

	public static <T> int countMatchingElements(Collection<T> coll, UnaryPredicate<T> predicate) {

		int count = 0;
		for (T item : coll) {
			if (predicate.matches(item))
				count++;
		}
		return count;
	}

	public static <T> void swapArrayElements(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
