package com.martinrist.sandbox.concurrency.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class ThreadLocalSample {

	protected void run() {
		Executor e = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 10; i++) {
			e.execute(getExecutable(i));
		}
	}

	protected abstract Runnable getExecutable(final int i);

}
