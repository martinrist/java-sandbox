package com.martinrist.sandbox.swing.listeners;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.DefaultFrame;

public class ColourChangeActionExample {

	public static void main(String[] args) {

		new ColourChangeActionExample().run();

	}

	public void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Frame frame = new ColourChangeActionFrame(
						"Colour Change Action Example");
				frame.setVisible(true);
			}
		});
	}

}

class ColourChangeActionFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();

	public ColourChangeActionFrame(String title) {
		super(title);

		JButton redButton = new JButton(new ColourAction("Red", Color.RED));
		JButton greenButton = new JButton(
				new ColourAction("Green", Color.GREEN));
		JButton blueButton = new JButton(new ColourAction("Blue", Color.BLUE));

		add(panel);
		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);

	}

	class ColourAction extends AbstractAction {

		private static final long serialVersionUID = 1L;
		private static final String COLOUR_KEY = "colour";

		public ColourAction(String name, Color col) {
			putValue(COLOUR_KEY, col);
			putValue(Action.NAME, name);
			putValue(Action.SHORT_DESCRIPTION, "Set colour to " + name);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue(COLOUR_KEY);
			panel.setBackground(c);
		}

	}

}
