package com.martinrist.sandbox.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import com.martinrist.sandbox.collections.impl.MapBackedPerformanceResultsCollector;

public class ListPerformanceTester {

	private static final int LIST_ADD_ITERATIONS = 100000;
	private static final int LIST_GET_ITERATIONS = 10000;
	private static final int LIST_REMOVE_ITERATIONS = 10000;

	private final PerformanceResultsCollector collector = new MapBackedPerformanceResultsCollector();

	private void testList(String implementation, List<Integer> list) {

		testListAdd(list, LIST_ADD_ITERATIONS);
		testListGet(list, LIST_GET_ITERATIONS);
		testListRemove(list, LIST_REMOVE_ITERATIONS);

	}

	private void testListAdd(List<Integer> list, int iterations) {

		long startTime = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			list.add(i);
		}
		long endTime = System.nanoTime();

		collector.addResult(list.getClass(), "add", endTime - startTime);

	}

	private void testListGet(List<Integer> list, int iterations) {

		long startTime = System.nanoTime();

		for (int i = 0; i < iterations; i++) {
			list.get(i);
		}

		long endTime = System.nanoTime();

		collector.addResult(list.getClass(), "get", endTime - startTime);

	}

	private void testListRemove(List<Integer> list, int iterations) {

		long startTime = System.nanoTime();

		for (int i = LIST_REMOVE_ITERATIONS - 1; i >= 0; i--) {
			list.remove(i);
		}

		long endTime = System.nanoTime();

		collector.addResult(list.getClass(), "remove", endTime - startTime);

	}

	public static void main(String[] args) {

		new ListPerformanceTester().test();

	}

	public void test() {

		testList("ArrayList", new ArrayList<Integer>());
		testList("LinkedList", new LinkedList<Integer>());
		testList("Vector", new Vector<Integer>());

		System.out.println("Results for 'add' tests:");
		System.out.println(collector.getResultsForTest("add"));

		System.out.println("Results for 'get' tests:");
		System.out.println(collector.getResultsForTest("get"));

		System.out.println("Results for 'remove' tests:");
		System.out.println(collector.getResultsForTest("remove"));

	}

}
