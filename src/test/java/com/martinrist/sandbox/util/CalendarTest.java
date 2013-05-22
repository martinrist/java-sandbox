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
	
	@Test
	public void test32ndJanIs1stFeb() {
		
		defaultCalendar.set(Calendar.MONTH, 0);
		defaultCalendar.set(Calendar.DAY_OF_MONTH, 32);
		
		assertEquals(1, defaultCalendar.get(Calendar.MONTH));
		assertEquals(1, defaultCalendar.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void testSettingDatePortionOnlyKeepsCurrentTimePortion() {
		
		Calendar then = Calendar.getInstance();
		Calendar now = Calendar.getInstance();
		now.set(2013, 0, 1);
		
		assertEquals(now.get(Calendar.HOUR_OF_DAY), then.get(Calendar.HOUR_OF_DAY));
		assertEquals(now.get(Calendar.MINUTE), then.get(Calendar.MINUTE));
		
		// This is going to fail if we've crossed a second boundary between creating 'then' and 'now'
		assertEquals(now.get(Calendar.SECOND), then.get(Calendar.SECOND));
		
	}
	
	
}
