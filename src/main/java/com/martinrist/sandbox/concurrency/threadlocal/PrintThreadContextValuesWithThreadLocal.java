package com.martinrist.sandbox.concurrency.threadlocal;

public class PrintThreadContextValuesWithThreadLocal {

	public static void printThreadContextValues() {
		System.out.println(ThreadContextWithThreadLocal.get());
	}
}
