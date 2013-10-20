package com.martinrist.sandbox.lang.generics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PairTest {

	private Pair<?> pair;

	@Test
	public void testCreateFromFirstArguments() {
		pair = Pair.fromFirstArguments(1, 2, 3, 4, 5, 6, 7);
		assertEquals(1, pair.getFirst());
		assertEquals(2, pair.getSecond());
	}

	@Test
	public void testAccessToStringPair() {
		pair = new Pair<String>("foo", "bar");
		assertEquals("foo", pair.getFirst());
		assertEquals("bar", pair.getSecond());
	}

	@Test
	public void testCreationUsingConstructorArgTypeInference() {
		pair = new Pair<>("foo", "bar");
		assertEquals("foo", pair.getFirst());
		assertTrue(pair.getFirst() instanceof String);
		assertEquals("bar", pair.getSecond());
		assertTrue(pair.getSecond() instanceof String);
	}

	@Test
	public void testCannotCreatePairOfMixedTypes() {
		// Compile error if uncommented
		// pair = new Pair<String>("foo", 1);
	}

	@Test
	public void testCanCreatePairWhereTypeOfSecondExtendsTypeOfFirst() {
		pair = new Pair<Base>(new Base(1), new Derived(1));
		assertTrue(pair.getFirst() instanceof Base);
		assertTrue(pair.getSecond() instanceof Derived);
	}

	@Test
	public void testGetLargerWhereSecondIsLargerReturnsSecond() {
		Base first = new Base(1);
		Base second = new Base(2);
		pair = new Pair<Base>(first, second);

		assertEquals(second, pair.getLarger());
	}

	@Test
	public void testGetLargerWhereFirstIsLargerReturnsFirst() {
		Base first = new Base(2);
		Base second = new Base(1);
		pair = new Pair<Base>(first, second);

		assertEquals(first, pair.getLarger());
	}

	@Test
	public void testGetLargerWhereBothEqualReturnsFirst() {
		Base first = new Base(1);
		Base second = new Base(1);
		pair = new Pair<Base>(first, second);

		assertEquals(first, pair.getLarger());
	}

	@Test
	public void testGetSmallerWhereSecondIsSmallerReturnsSecond() {
		Base first = new Base(2);
		Base second = new Base(1);
		pair = new Pair<Base>(first, second);

		assertEquals(second, pair.getSmaller());
	}

	@Test
	public void testGetSmallerWhereFirstIsSmallerReturnsFirst() {
		Base first = new Base(1);
		Base second = new Base(2);
		pair = new Pair<Base>(first, second);

		assertEquals(first, pair.getSmaller());
	}

	@Test
	public void testGetSmallerWhereBothEqualReturnsFirst() {
		Base first = new Base(1);
		Base second = new Base(1);
		pair = new Pair<Base>(first, second);

		assertEquals(first, pair.getSmaller());
	}

	@Test
	public void testGetClassReturnsRawType() {
		pair = new Pair<String>("foo", "bar");
		assertEquals(Pair.class, pair.getClass());
	}

	@Test
	public void testCannotCreateArrayOfParametrisedPairs() {
		// Compilation error if uncommented
		//Pair<String>[] stringPairs = new Pair<String>[10];
	}

	@Test
	public void testSafeVarargs() {
		Pair<String> pair1 = new Pair<>("pair1first", "pair1second");
		Pair<String> pair2 = new Pair<>("pair2first", "pair2second");

		List<Pair<String>> pairs = new ArrayList<>();

		Collections.addAll(pairs, pair1, pair2);
	}
}