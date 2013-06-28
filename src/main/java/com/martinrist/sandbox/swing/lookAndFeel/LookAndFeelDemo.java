package com.martinrist.sandbox.swing.lookAndFeel;

import javax.swing.SwingUtilities;

public class LookAndFeelDemo {

	public static void main(String[] args) {

		new LookAndFeelDemo().run();

	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				LookAndFeelFrame frame = new LookAndFeelFrame("Look and Feel Demo");
				frame.setVisible(true);
			}
		});

	}
}
