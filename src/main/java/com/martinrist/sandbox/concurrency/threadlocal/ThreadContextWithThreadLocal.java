package com.martinrist.sandbox.concurrency.threadlocal;

public class ThreadContextWithThreadLocal extends ThreadContext {

	private static ThreadLocal<ThreadContextWithThreadLocal> threadLocal = new ThreadLocal<ThreadContextWithThreadLocal>() {

		@Override
		protected ThreadContextWithThreadLocal initialValue() {
			return new ThreadContextWithThreadLocal();
		}
	};

	public ThreadContext get() {
		return threadLocal.get();
	}

}
