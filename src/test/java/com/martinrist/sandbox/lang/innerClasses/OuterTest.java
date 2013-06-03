package com.martinrist.sandbox.lang.innerClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.martinrist.sandbox.lang.innerClasses.Outer.Inner;

public class OuterTest {

	private final Outer outer = new Outer();

	@Test
	public void testCreateInnerWithConstructor() {
		Inner inner = outer.new Inner();
		assertNotNull(inner);
	}

	@Test
	public void testCreateInnerWithMethod() {
		Inner inner = outer.inner();
		assertNotNull(inner);
	}

	@Test
	public void testGettingOuterFromInnerReturnsOriginalOuter() {
		Inner inner = outer.inner();
		Outer enclosingOuter = inner.getOuter();
		assertTrue(outer == enclosingOuter);
	}

	@Test
	public void testGettingThisFromInnerReturnsInner() {
		Inner inner = outer.inner();
		Inner innerThis = inner.getThis();
		assertTrue(inner == innerThis);
	}

	@Test
	public void testInnerCanAccessPrivateMemberInOuter() {
		Inner inner = outer.inner();
		assertEquals("anon", inner.toString());
	}
}
