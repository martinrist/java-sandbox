package com.martinrist.sandbox.concurrency.threadlocal;

public class ThreadLocalSampleWithCustomThreadLocal extends ThreadLocalSample {

	public static void main(String[] args) {
		new ThreadLocalSampleWithCustomThreadLocal().run();
	}

	@Override
	protected Runnable getExecutable(final int i) {

		return new Runnable() {
			@Override
			public void run() {
				ThreadContext threadContext = new ThreadContext();
				threadContext.setTransactionId((long) i);
				threadContext.setUserId("Custom Thread Local User " + i);
				CustomThreadLocal.add(threadContext);
				PrintThreadContextValuesWithCustomThreadLocal
						.printThreadContextValues();
			}
		};

	}
}
