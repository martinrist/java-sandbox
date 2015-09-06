package com.martinrist.sandbox.lang.generics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class PairTest {

	private Pair<?> pair;

	@Test
	@Ignore
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

	@Test
	@SuppressWarnings("unused")
	public void testDerivedPairNotAssignableToBasePair() {
		Base b = new Derived(1); // I can do this - Derived extends Base
		Base[] bArr = new Derived[10]; // I can also do this - Derived[] extends Base[]

		// But this doesn't work - can't assign Pair<Derived> to Pair<Base>
		//Pair<Base> basePair = new Pair<Derived>(new Derived(1), new Derived(2));

	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Test
	public void testReferencingUsingRawTypesDefeatsTypeSafety() {
		Pair rawPair = new Pair<Base>(new Base(1), new Base(2));
		rawPair.setSecond("foo"); // Defeats type safety

		assertEquals(Base.class, rawPair.getFirst().getClass());
		assertEquals(String.class, rawPair.getSecond().getClass());

		try {
			@SuppressWarnings("unused")
			Base second = (Base) rawPair.getSecond();
			fail("This should have thrown a ClassCastException");
		} catch (ClassCastException cce) {
			// This behaviour is expected
		}

	}

	@Test
	public void testReferenceUsingUpperBoundedWildcard() {

		Pair<? extends Base> pairExtendingBase = new Pair<Derived>(new Derived(1), new Derived(2));

		// Can get as upper bound (Base)
		Base first = pairExtendingBase.getFirst();
		assertEquals(1, first.getValue());

		// Can only set as null
		//pairExtendingBase.setFirst(new Derived(3));   // Compile error if uncommented
		pairExtendingBase.setFirst(null);
		assertNull(pairExtendingBase.getFirst());

	}

	@Test
	public void testReferenceUsingLowerBoundedWildcard() {

		List<? super Derived> listSuperDerived = new ArrayList<Base>();

		// Can set
		listSuperDerived.add(new Derived(1));

		// Can only get as Object
		@SuppressWarnings("unused")
		Object first = listSuperDerived.get(0);

	}

}
