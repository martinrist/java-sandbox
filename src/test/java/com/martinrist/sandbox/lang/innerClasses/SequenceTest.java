package com.martinrist.sandbox.lang.innerClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.martinrist.sandbox.lang.innerClasses.Sequence.Selector;

public class SequenceTest {

	private Sequence seq;
	private Selector sel;

	@Before
	public void setUp() {
		seq = new Sequence(3);

		seq.add(new StringHolder("One"));
		seq.add(new StringHolder("Two"));
		seq.add(new StringHolder("Three"));

	}

	@Test
	public void testIterationOverStringHolders() {

		sel = seq.selector();
		assertEquals(((StringHolder) sel.current()).getContents(), "One");
		sel.next();
		assertFalse(sel.end());

		assertEquals(((StringHolder) sel.current()).getContents(), "Two");
		sel.next();
		assertFalse(sel.end());

		assertEquals(((StringHolder) sel.current()).getContents(), "Three");
		sel.next();
		assertTrue(sel.end());
	}

	@Test
	public void testReverseIterationOverStringHolders() {

		sel = seq.reverseSelector();

		assertEquals(((StringHolder) sel.current()).getContents(), "Three");
		sel.next();
		assertFalse(sel.end());

		assertEquals(((StringHolder) sel.current()).getContents(), "Two");
		sel.next();
		assertFalse(sel.end());

		assertEquals(((StringHolder) sel.current()).getContents(), "One");
		sel.next();
		assertTrue(sel.end());
	}

	@Test
	public void testGettingSequenceBackFromSelector() {

		sel = seq.reverseSelector();

		Sequence outerSeq = sel.getSequence();
		assertTrue(seq == outerSeq);
	}
}
