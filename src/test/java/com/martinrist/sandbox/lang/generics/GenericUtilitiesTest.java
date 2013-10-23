package com.martinrist.sandbox.lang.generics;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class GenericUtilitiesTest {

	Collection<Integer> intColl = new ArrayList<>();
	Collection<String> stringColl = new ArrayList<>();

	@Before
	public void setUp() {
		for (int i = 0; i < 10; i++) {
			intColl.add(i);
		}

		stringColl.add("foobar");
		stringColl.add("madam");
		stringColl.add("civic");
		stringColl.add("radar");
		stringColl.add(null);
		stringColl.add("wibble");
	}

	@Test
	public void testCountMatchingElements_FailAllPredicate() {
		int result = GenericUtilities.countMatchingElements(intColl, new UnaryPredicate<Integer>() {
			@Override
			public boolean matches(Integer item) {
				return false;
			}
		});
		assertEquals(0, result);
	}

	@Test
	public void testCountMatchingElements_PassAllPredicate() {
		int result = GenericUtilities.countMatchingElements(intColl, new UnaryPredicate<Integer>() {
			@Override
			public boolean matches(Integer item) {
				return true;
			}
		});
		assertEquals(intColl.size(), result);
	}

	@Test
	public void testCountMatchingElements_PalindromePredicate() {
		int result = GenericUtilities.countMatchingElements(stringColl, new UnaryPredicate<String>() {
			@Override
			public boolean matches(String item) {
				if (item == null)
					return false;
				return (StringUtils.reverse(item).equals(item));
			}
		});
		assertEquals(3, result);
	}

	@Test
	public void testSwapArrayElements_DifferentIndicesInBounds() {
		Integer[] array = {1, 2, 3, 4};
		GenericUtilities.swapArrayElements(array, 1, 2);
		assertArrayEquals(new Integer[] {1, 3, 2, 4}, array);
	}

	@Test
	public void testSwapArrayElements_SameIndicesInBounds() {
		Integer[] array = {1, 2, 3, 4};
		GenericUtilities.swapArrayElements(array, 1, 1);
		assertArrayEquals(new Integer[] {1, 2, 3, 4}, array);
	}

	@Test
	public void testSwapArrayElements_NegativeLowerIndex() {
		Integer[] array = {1, 2, 3, 4};
		try {
			GenericUtilities.swapArrayElements(array, -1, 1);
			fail("ArrayIndexOutOfBoundsException expected");
		} catch (IndexOutOfBoundsException ioobe) {
			// Expected behaviour
		}
	}

	@Test
	public void testSwapArrayElements_UpperIndexOutOfBounds() {
		Integer[] array = {1, 2, 3, 4};
		try {
			GenericUtilities.swapArrayElements(array, 1, 5);
			fail("ArrayIndexOutOfBoundsException expected");
		} catch (IndexOutOfBoundsException ioobe) {
			// Expected behaviour
		}
	}

}
