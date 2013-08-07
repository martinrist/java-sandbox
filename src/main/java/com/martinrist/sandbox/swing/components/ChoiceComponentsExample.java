package com.martinrist.sandbox.swing.components;

import java.awt.Frame;

import javax.swing.SwingUtilities;


public class ChoiceComponentsExample {

	public static void main(final String[] args) {
		new ChoiceComponentsExample().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Frame frame = new ChoiceComponentsFrame("Choice Component Examples");
				frame.setVisible(true);
			}
		});
	}
}
