package com.martinrist.sandbox.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Objects;

import org.junit.Test;

public class ObjectsTest {

	@Test
	public void testTwoNullsAreEqual() {
		assertTrue(Objects.equals(null, null));
	}

	@Test
	public void testOneNullUnequal() {
		assertFalse(Objects.equals(null, Integer.valueOf(1)));
		assertFalse(Objects.equals(Integer.valueOf(1), null));

	}

}
