package com.martinrist.sandbox.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class CalendarTest {

	Calendar defaultCalendar = Calendar.getInstance();

	@Test
	public void testCalendarFactoryMethodReturnsGregorianCalendar() {

		assertTrue(defaultCalendar instanceof GregorianCalendar);
	}

	@Test
	public void testCalendarJanuaryIsMonthZero() {

		defaultCalendar.set(Calendar.MONTH, Calendar.JANUARY);
		assertEquals(0, defaultCalendar.get(Calendar.MONTH));
	}
}
