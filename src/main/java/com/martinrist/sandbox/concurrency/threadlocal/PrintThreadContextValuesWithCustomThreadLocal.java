package com.martinrist.sandbox.concurrency.threadlocal;

public class PrintThreadContextValuesWithCustomThreadLocal {

	public static void printThreadContextValues() {
		System.out.println(CustomThreadLocal.get());
	}
}
