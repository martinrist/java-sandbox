package com.martinrist.sandbox.concurrency.threadlocal;

public class ThreadContextWithCustomThreadLocal {

	private String userId;

	private Long transactionId;

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
