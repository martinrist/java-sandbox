package com.martinrist.sandbox.util;

import org.junit.After;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ScannerTest {

	private Scanner scanner;
	
	@After
	public void tearDown() throws Exception {
		scanner.close();
	}

	@Test
	public void testStringTraversalWithWhitespace() {
		scanner = new Scanner("The quick\nbrown\tfox\rjumps   over\t\tthe\n\nlazy\r\fdog");
		verifyCorrectTokensReturned();
	}
	
	@Test
	public void testStringTraversalWithCustomDelimiter() {
		scanner = new Scanner("The|quick|brown|fox|jumps|over|the|lazy|dog");
		scanner.useDelimiter("\\|");
		verifyCorrectTokensReturned();
	}
	
	private void verifyCorrectTokensReturned() {
		assertEquals("The", scanner.next());
		assertEquals("quick", scanner.next());
		assertEquals("brown", scanner.next());
		assertEquals("fox", scanner.next());
		assertEquals("jumps", scanner.next());
		assertEquals("over", scanner.next());
		assertEquals("the", scanner.next());
		assertEquals("lazy", scanner.next());
		assertEquals("dog", scanner.next());
	}
	
}
