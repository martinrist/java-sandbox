package com.martinrist.sandbox.concurrency.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadLocalSampleWithCustomThreadLocal {

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
				ThreadContextWithCustomThreadLocal threadContext = new ThreadContextWithCustomThreadLocal();
				threadContext.setTransactionId((long) i);
				threadContext.setUserId("User " + i);
				CustomThreadLocal.add(threadContext);
				PrintThreadContextValuesWithCustomThreadLocal.printThreadContextValues();
			}
		};

	}
}
