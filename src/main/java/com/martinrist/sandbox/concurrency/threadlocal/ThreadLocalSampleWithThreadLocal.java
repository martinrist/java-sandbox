package com.martinrist.sandbox.concurrency.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadLocalSampleWithThreadLocal {

	public static void main(String[] args) {

		Executor e = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 10; i++) {
			e.execute(getExecutable(i));
		}
	}

	private static Runnable getExecutable(final int i) {

		return new Runnable() {
			@Override
			public void run() {
				ThreadContextWithThreadLocal threadContext = ThreadContextWithThreadLocal
						.get();
				threadContext.setTransactionId((long) i);
				threadContext.setUserId("User " + i);
				PrintThreadContextValuesWithThreadLocal
						.printThreadContextValues();
			}
		};

	}
}
