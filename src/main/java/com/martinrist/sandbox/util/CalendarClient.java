package com.martinrist.sandbox.util;

import java.io.PrintStream;
import java.util.Calendar;

public class CalendarClient {
	
	public static void main(String[] args) {
		
		CalendarClient client = new CalendarClient();
		client.run();
		
	}

	
	public void run() {

		Calendar cal = Calendar.getInstance();
		outputCalendarFields(System.out, cal);
		
	}
	
	
	private void outputCalendarFields(PrintStream out, Calendar cal) {

		out.format("Calendar object : %s\n", cal.toString());
		out.format("YEAR = %d\n", cal.get(Calendar.YEAR));
		out.format("MONTH = %d\n", cal.get(Calendar.MONTH));
		out.format("DAY_OF_MONTH = %d\n", cal.get(Calendar.DAY_OF_MONTH));
		
	}
}
