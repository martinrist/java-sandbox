package com.martinrist.sandbox.logging.jul;

import static java.util.logging.Level.CONFIG;
import static java.util.logging.Level.FINE;
import static java.util.logging.Level.FINER;
import static java.util.logging.Level.FINEST;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CustomLogFilterExample {

	private static final Logger LOG = Logger.getLogger(CustomLogFilterExample.class.getName());

	static {
		LOG.setFilter(new EvenParameterFilter());
	}

	// Make sure you configure the logging subsystem in $JAVA_HOME/jre/lib/logging.properties
	// Note: To make levels below INFO appear, you will need to change both the Logger and Handler config

	public static void main(String[] args) {
		new CustomLogFilterExample().run();
	}

	private void run() {
		LOG.entering(getClass().getName(), "run");

		for (int i = 0; i < 10; i++) {
			logMessages(i);
		}
	}

	private void logMessages(int iteration) {

		String loggerName = LOG.getName();
		logMessageForIteration(loggerName, SEVERE, iteration);
		logMessageForIteration(loggerName, INFO, iteration);
		logMessageForIteration(loggerName, WARNING, iteration);
		logMessageForIteration(loggerName, CONFIG, iteration);
		logMessageForIteration(loggerName, FINE, iteration);
		logMessageForIteration(loggerName, FINER, iteration);
		logMessageForIteration(loggerName, FINEST, iteration);

	}

	private void logMessageForIteration(String loggerName, Level level, int iteration) {
		String messageTemplate = "Logging to logger '%s' at level %s for iteration %d";
		LOG.log(level, String.format(messageTemplate, loggerName, level, iteration), iteration);
	}
}

/*
 * Filter that only logs a LogRecord whose parameter is an even Integer
 */
class EvenParameterFilter implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		Object[] objParams = record.getParameters();

		if (objParams == null || objParams.length == 0)
			return false;

		if (objParams[0] instanceof Integer) {
			int param = ((Integer) objParams[0]).intValue();
			return (param % 2) == 0;
		} else {
			return false;
		}

	}
}
