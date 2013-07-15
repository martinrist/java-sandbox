package com.martinrist.sandbox.swing.layout;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.DefaultFrame;

public class BorderLayoutExample {

	public static void main(final String[] args) {
		new BorderLayoutExample().run();
	}

	private void run() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Frame frame = new BorderLayoutExampleFrame("Border Layout Example");
				frame.setVisible(true);
			}
		});
	}
}

class BorderLayoutExampleFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	public BorderLayoutExampleFrame(final String title) {
		super(title);

		addButton("North", BorderLayout.NORTH);
		addButton("East", BorderLayout.EAST);
		addButton("South", BorderLayout.SOUTH);
		addButton("West", BorderLayout.WEST);
		addButton("Centre", BorderLayout.CENTER);

	}

	private void addButton(final String title, final String position) {

		JButton button = new JButton(title);
		add(button, position);
	}
}
