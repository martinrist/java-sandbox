package com.martinrist.sandbox.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.martinrist.sandbox.collections.impl.MapBackedPerformanceResultsCollector;

public class PerformanceResultsCollectorTest {

	PerformanceResultsCollector collector = new MapBackedPerformanceResultsCollector();

	@Test
	public void testAddAndRetrieveForNewClass() {
		collector.addResult(Object.class, "test1", 1L);
		long actual = collector.getResult(Object.class, "test1");
		assertEquals(1L, actual);
	}

	@Test
	public void testAddAndRetrieveForDifferentClassNull() {
		collector.addResult(Object.class, "test1", 1L);
		assertNull(collector.getResult(this.getClass(), "test1"));
	}

	@Test
	public void testAddAndRetrieveForDifferentTestReturnsNull() {
		collector.addResult(Object.class, "test1", 1L);
		assertNull(collector.getResult(Object.class, "test2"));
	}

	@Test
	public void testAddAndOverwriteForSameClassAndMethod() {
		collector.addResult(Object.class, "test1", 1L);
		collector.addResult(Object.class, "test1", 10L);
		long actual = collector.getResult(Object.class, "test1");
		assertEquals(10L, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddingWithNullClassThrowsIllegalArgumentException() {
		collector.addResult(null, "test1", 1L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdddingWithNullTestNameThrowsIllegalArgumentException() {
		collector.addResult(Object.class, null, 1L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdddingWithEmptyTestNameThrowsIllegalArgumentException() {
		collector.addResult(Object.class, "", 1L);
	}

	@Test
	public void testGetResultsForClass() {

		collector.addResult(Object.class, "test1", 1L);
		collector.addResult(Object.class, "test2", 2L);
		collector.addResult(Object.class, "test3", 3L);

		Map<String, Long> actual = collector.getResultsForClass(Object.class);

		Map<String, Long> expected = new HashMap<>();
		expected.put("test3", 3L);
		expected.put("test2", 2L);
		expected.put("test1", 1L);

		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetResultsForNullClass() {
		collector.getResultsForClass(null);
	}

	@Test
	public void testGetResultsForTest() {

		collector.addResult(Integer.class, "test1", 1L);
		collector.addResult(Long.class, "test1", 10L);
		collector.addResult(Double.class, "test1", 100L);

		Map<Class<?>, Long> actual = collector.getResultsForTest("test1");

		Map<Class<?>, Long> expected = new HashMap<>();
		expected.put(Double.class, 100L);
		expected.put(Long.class, 10L);
		expected.put(Integer.class, 1L);

		assertEquals(expected, actual);

	}

	@Test
	public void testGetResultsForTestWithoutEntriesReturnsEmptyMap() {
		collector.addResult(Integer.class, "test1", 1L);
		Map<Class<?>, Long> actual = collector.getResultsForTest("test2");
		assertEquals(Collections.EMPTY_MAP, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetResultsForNullTestThrowsException() {
		collector.getResultsForTest(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetResultsForEmptyTestThrowsException() {
		collector.getResultsForTest("");
	}

}
