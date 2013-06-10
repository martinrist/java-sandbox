package com.martinrist.sandbox.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class EmptyFrameTester {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new EmptyFrame();
				frame.setVisible(true);

			}
		});

	}
}

class EmptyFrame extends DefaultFrame {

}
