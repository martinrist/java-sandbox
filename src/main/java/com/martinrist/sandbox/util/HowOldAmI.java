package com.martinrist.sandbox.util;

import java.io.PrintStream;
import java.util.Scanner;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.PeriodFormat;

public class HowOldAmI {

	private static final PrintStream OUT = System.out;
	private static final Scanner IN = new Scanner(System.in);

	public static void main(String[] args) {
		HowOldAmI client = new HowOldAmI();
		client.run();
	}

	private void run() {

		while (true) {
			DateTime birthDate = getValidatedUserInput();
			if (birthDate == null) {
				break;
			}
			OUT.format("You are %s old\n", getCurrentAge(birthDate));
		}

		OUT.format("Done!");

	}

	private DateTime getValidatedUserInput() {

		DateTime birthDate = null;

		do {
			OUT.print("Enter your birth date ('return' to end): ");
			String input = IN.nextLine();
			if ("".equals(input)) {
				return null;
			}
			try {
				birthDate = parseBirthDate(input);
			} catch (IllegalArgumentException iae) {
				OUT.format("Unable to parse birth date : %s\n", input);
			}
		} while (birthDate == null);

		return birthDate;

	}

	private DateTime parseBirthDate(String input) {
		DateTimeFormatter parser = ISODateTimeFormat.date();
		DateTime birthDate = parser.parseDateTime(input);
		return birthDate;
	}

	private String getCurrentAge(DateTime birthDate) {
		DateTime now = new DateTime();
		Period agePeriod = new Period(birthDate, now);
		return PeriodFormat.wordBased().print(agePeriod);
	}

}
