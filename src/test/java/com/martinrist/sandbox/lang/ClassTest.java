package com.martinrist.sandbox.lang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClassTest {

	@Test
	public void testGetClassAndDotClassReturnSameClass() {
		String testString = "This is a test";
		assertEquals(String.class, testString.getClass());
	}

	@Test
	public void testClassNameOfObject() {
		assertEquals("java.lang.String", String.class.getName());
	}

	@Test
	public void testClassNameOfPrimitive() {
		assertEquals("int", int.class.getName());
	}

	@Test
	public void testClassNameOfVoid() {
		assertEquals("void", void.class.getName());
	}

	@Test
	public void testClassNameOf1DObjectArray() {
		String[] strings = {"One", "Two", "Three"};
		assertEquals("[Ljava.lang.String;", strings.getClass().getName());
	}

	@Test
	public void testClassNameOf2DObjectArray() {
		String[][] strings = { {"One", "Two", "Three"}, {"1", "2", "3"}};
		assertEquals("[[Ljava.lang.String;", strings.getClass().getName());
	}

	@Test
	public void testClassNameOf1DPrimitiveArray() {
		int[] ints = {1, 2, 3};
		assertEquals("[I", ints.getClass().getName());
	}

	@Test
	public void testClassSimpleNameOfObject() {
		assertEquals("String", String.class.getSimpleName());
	}

	@Test
	public void testClassSimpleNameOfPrimitive() {
		assertEquals("int", int.class.getSimpleName());
	}

	@Test
	public void testClassSimpleNameOf1DObjectArray() {
		String[] strings = {"One", "Two", "Three"};
		assertEquals("String[]", strings.getClass().getSimpleName());
	}

	@Test
	public void testClassSimpleNameOf2DObjectArray() {
		String[][] strings = { {"One", "Two", "Three"}, {"1", "2", "3"}};
		assertEquals("String[][]", strings.getClass().getSimpleName());
	}

	@Test
	public void testClassSimpleNameOf1DPrimitiveArray() {
		int[] ints = {1, 2, 3};
		assertEquals("int[]", ints.getClass().getSimpleName());
	}

}
