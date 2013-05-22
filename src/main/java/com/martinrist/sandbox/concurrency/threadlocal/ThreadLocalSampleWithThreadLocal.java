package com.martinrist.sandbox.concurrency.threadlocal;

public class ThreadLocalSampleWithThreadLocal extends ThreadLocalSample {

	public static void main(String[] args) {
		new ThreadLocalSampleWithThreadLocal().run();
	}

	@Override
	protected Runnable getExecutable(final int i) {

		return new Runnable() {
			@Override
			public void run() {
				ThreadContext threadContext = new ThreadContextWithThreadLocal().get();
				threadContext.setTransactionId((long) i);
				threadContext.setUserId("ThreadLocal User " + i);
				PrintThreadContextValuesWithThreadLocal.printThreadContextValues();
			}
		};

	}
}
