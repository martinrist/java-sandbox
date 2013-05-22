package com.martinrist.sandbox.concurrency.threadlocal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CustomThreadLocal {

	private static ConcurrentMap<Thread, Object> threadMap = new ConcurrentHashMap<>();

	public static void add(Object object) {
		threadMap.put(Thread.currentThread(), object);
	}

	public static void remove() {
		threadMap.remove(Thread.currentThread());
	}

	public static Object get() {
		return threadMap.get(Thread.currentThread());
	}

}
