package com.martinrist.sandbox.swing.listeners;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
				Frame frame = new ColourChangeActionFrame("Colour Change Action Example");
				frame.setVisible(true);
			}
		});
	}

}

class ColourChangeActionFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();

	List<JButton> buttons = new ArrayList<>();

	public ColourChangeActionFrame(String title) {
		super(title);

		JButton redButton = new JButton(new ColourAction("Red", Color.RED));
		JButton greenButton = new JButton(new ColourAction("Green", Color.GREEN));
		JButton blueButton = new JButton(new ColourAction("Blue", Color.BLUE));

		buttons.add(redButton);
		buttons.add(greenButton);
		buttons.add(blueButton);

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
			putValue(Action.SMALL_ICON, createButtonIcon(name));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue(COLOUR_KEY);
			panel.setBackground(c);

			JButton source = (JButton) e.getSource();
			source.setEnabled(false);
			enableOtherButtons(source);
		}

		private void enableOtherButtons(JButton clickedButton) {
			for (JButton button : buttons) {
				if (!button.equals(clickedButton)) {
					button.setEnabled(true);
				}
			}
		}

		private Icon createButtonIcon(String name) {
			URL iconUrl = this.getClass().getResource("/com/martinrist/sandbox/swing/listeners/" + name + ".png");
			Image unscaledImage = new ImageIcon(iconUrl).getImage();
			Image scaledImage = unscaledImage.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			Icon scaledIcon = new ImageIcon(scaledImage);
			return scaledIcon;
		}
	}

}
