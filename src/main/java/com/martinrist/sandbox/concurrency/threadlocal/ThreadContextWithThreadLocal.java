package com.martinrist.sandbox.concurrency.threadlocal;


public class ThreadContextWithThreadLocal {

	private String userId;

	private Long transactionId;

	private static ThreadLocal<ThreadContextWithThreadLocal> threadLocal = new ThreadLocal<ThreadContextWithThreadLocal>() {

		@Override
		protected ThreadContextWithThreadLocal initialValue() {
			return new ThreadContextWithThreadLocal();
		}
	};

	public static ThreadContextWithThreadLocal get() {
		return threadLocal.get();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "userId:" + userId + ",transactionId:" + transactionId;
	}
}
