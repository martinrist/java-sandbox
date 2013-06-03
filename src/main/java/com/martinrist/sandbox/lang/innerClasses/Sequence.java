package com.martinrist.sandbox.lang.innerClasses;

public class Sequence {

	interface Selector {
		boolean end();

		Object current();

		void next();

		Sequence getSequence();

	}

	private final Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length) {
			items[next++] = x;
		}
	}

	public Selector selector() {
		return new SequenceSelector();
	}

	private class SequenceSelector extends AbstractSequenceSelector {

		public SequenceSelector() {
			i = 0;
		}

		@Override
		public boolean end() {
			return (i == items.length);
		}

		@Override
		public void next() {
			if (i < items.length) {
				i++;
			}
		}
	}

	public Selector reverseSelector() {
		return new ReverseSequenceSelector();
	}

	private class ReverseSequenceSelector extends AbstractSequenceSelector {

		public ReverseSequenceSelector() {
			i = items.length - 1;
		}

		@Override
		public boolean end() {
			return (i == -1);
		}

		@Override
		public void next() {
			if (i >= 0) {
				i--;
			}
		}

	}

	private abstract class AbstractSequenceSelector implements Selector {

		protected int i;

		@Override
		public Sequence getSequence() {
			return Sequence.this;
		}

		@Override
		public Object current() {
			return items[i];
		}

	}
}
