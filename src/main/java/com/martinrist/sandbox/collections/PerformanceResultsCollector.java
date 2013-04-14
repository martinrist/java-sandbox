package com.martinrist.sandbox.collections;

import java.util.Map;

public interface PerformanceResultsCollector {

	public abstract void addResult(Class<?> clazz, String testName,
			Long duration);

	public abstract Long getResult(Class<?> clazz, String testName);

	public abstract Map<String, Long> getResultsForClass(Class<?> clazz);

	public abstract Map<Class<?>, Long> getResultsForTest(String testName);

	public abstract Map<Class<?>, Map<String, Long>> getAllResults();

}