package com.martinrist.sandbox.collections.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.martinrist.sandbox.collections.PerformanceResultsCollector;

public class MapBackedPerformanceResultsCollector implements PerformanceResultsCollector {

	private final Map<Class<?>, Map<String, Long>> results = new ConcurrentHashMap<>();

	/* (non-Javadoc)
	 * @see com.martinrist.sandbox.collections.PerformanceResultsCollector#addResult(java.lang.Class, java.lang.String, java.lang.Long)
	 */
	@Override
	public void addResult(Class<?> clazz, String testName, Long duration) {

		if (clazz == null) {
			throw new IllegalArgumentException("Class cannot be null");
		}

		if (testName == null || testName.isEmpty()) {
			throw new IllegalArgumentException(
					"Test name cannot be null or empty");
		}
		Map<String, Long> metricValue = results.get(clazz);

		if (metricValue == null) {
			metricValue = new HashMap<>();
			results.put(clazz, metricValue);
		}

		metricValue.put(testName, duration);

	}

	/* (non-Javadoc)
	 * @see com.martinrist.sandbox.collections.PerformanceResultsCollector#getResult(java.lang.Class, java.lang.String)
	 */
	@Override
	public Long getResult(Class<?> clazz, String testName) {

		Map<String, Long> metricValue = results.get(clazz);

		if (metricValue == null) {
			return null;
		} else {
			return results.get(clazz).get(testName);
		}
	}

	/* (non-Javadoc)
	 * @see com.martinrist.sandbox.collections.PerformanceResultsCollector#getResultsForClass(java.lang.Class)
	 */
	@Override
	public Map<String, Long> getResultsForClass(Class<?> clazz) {

		if (clazz == null) {
			throw new IllegalArgumentException("Class cannot be null");
		}
		return results.get(clazz);
	}

	/* (non-Javadoc)
	 * @see com.martinrist.sandbox.collections.PerformanceResultsCollector#getResultsForTest(java.lang.String)
	 */
	@Override
	public Map<Class<?>, Long> getResultsForTest(String testName) {

		if (testName == null || testName.isEmpty()) {
			throw new IllegalArgumentException(
					"Test name cannot be null or empty");
		}

		Map<Class<?>, Long> resultsForTest = new HashMap<>();

		for (Entry<Class<?>, Map<String, Long>> entry : results.entrySet()) {
			Long duration = entry.getValue().get(testName);
			if (duration != null) {
				resultsForTest.put(entry.getKey(), duration);
			}
		}

		return resultsForTest;

	}

	/* (non-Javadoc)
	 * @see com.martinrist.sandbox.collections.PerformanceResultsCollector#getAllResults()
	 */
	@Override
	public Map<Class<?>, Map<String, Long>> getAllResults() {
		return results;
	}
}
