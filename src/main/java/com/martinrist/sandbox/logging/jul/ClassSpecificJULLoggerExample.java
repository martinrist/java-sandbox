package com.martinrist.sandbox.logging.jul;

import java.util.logging.Logger;

public class ClassSpecificJULLoggerExample {

	private static final Logger LOG = Logger.getLogger(ClassSpecificJULLoggerExample.class.getName());

	// Make sure you configure the logging subsystem in $JAVA_HOME/jre/lib/logging.properties
	// Note: To make levels below INFO appear, you will need to change both the Logger and Handler config

	public static void main(String[] args) {

		LOG.info("About to start running example");
		new ClassSpecificJULLoggerExample().run();
		LOG.info("Finished running example");

	}

	private void run() {

		LOG.entering(getClass().getName(), "run");
		LOG.severe(String.format("Logging to logger '%s' at level SEVERE", LOG.getName()));
		LOG.info(String.format("Logging to logger '%s' at level INFO", LOG.getName()));
		LOG.warning(String.format("Logging to logger '%s' at level WARNING", LOG.getName()));
		LOG.config(String.format("Logging to logger '%s' at level CONFIG", LOG.getName()));
		LOG.fine(String.format("Logging to logger '%s' at level FINE", LOG.getName()));
		LOG.finer(String.format("Logging to logger '%s' at level FINER", LOG.getName()));
		LOG.finest(String.format("Logging to logger '%s' at level FINEST", LOG.getName()));
		LOG.exiting(getClass().getName(), "run");
	}
}
