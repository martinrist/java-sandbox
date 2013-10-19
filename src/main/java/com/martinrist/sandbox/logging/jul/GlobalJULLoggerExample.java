package com.martinrist.sandbox.logging.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalJULLoggerExample {

	private static final Logger LOG = Logger.getGlobal();

	static {
		LOG.setLevel(Level.INFO);
	}

	public static void main(String[] args) {

		LOG.info("About to start running example");
		new GlobalJULLoggerExample().run();
		LOG.info("Finished running example");

	}

	private void run() {

		for (int i = 0; i < 10; i++) {
			LOG.info(String.format("Logging to logger '%s' at level INFO for iteration %d", LOG.getName(), i));
			LOG.warning(String.format("Logging to logger '%s' at level WARNING for iteration %d", LOG.getName(), i));
		}
	}
}
