package com.martinrist.sandbox.lang;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringInterningTest {

	@Test
	public void testStringsCreatedFromLiteralsAreIdentical() {
		String s1 = "foo";
		String s2 = "foo";
		assertTrue(s1 == s2);
	}

	@Test
	public void testStringsCreatedFromStringConstructorAreNotIdentical() {
		String s1 = new String("foo");
		String s2 = new String("foo");
		assertFalse(s1 == s2);
		assertTrue(s1.equals(s2));
	}

}
