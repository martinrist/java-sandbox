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
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
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

		addColour("Red", Color.RED, "ctrl R");
		addColour("Green", Color.GREEN, "ctrl G");
		addColour("Blue", Color.BLUE, "ctrl B");
		addColour("Black", Color.BLACK, "ctrl K");

		add(panel);

	}

	private void addColour(String colourName, Color colour, String acceleratorKey) {
		ColourAction action = new ColourAction(colourName, colour);
		JButton button = new JButton(action);
		InputMap imap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		String actionMapKey = "action." + colourName;
		imap.put(KeyStroke.getKeyStroke(acceleratorKey), actionMapKey);
		ActionMap amap = panel.getActionMap();
		amap.put(actionMapKey, action);
		panel.add(button);

	}

	class ColourAction extends AbstractAction {

		private static final int ICON_SIZE = 15;
		private static final long serialVersionUID = 1L;
		private static final String COLOUR_KEY = "colour";

		public ColourAction(String name, Color col) {
			putValue(COLOUR_KEY, col);
			putValue(Action.NAME, name);
			putValue(Action.SHORT_DESCRIPTION, "Set colour to " + name);

			Icon buttonIcon = createButtonIcon(name);
			if (buttonIcon != null) {
				putValue(Action.SMALL_ICON, buttonIcon);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue(COLOUR_KEY);
			panel.setBackground(c);
		}

		private Icon createButtonIcon(String name) {
			URL iconUrl = this.getClass().getResource("/com/martinrist/sandbox/swing/listeners/" + name + ".png");
			if (iconUrl == null) {
				return null;
			}

			Image unscaledImage = new ImageIcon(iconUrl).getImage();
			Image scaledImage = unscaledImage.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_DEFAULT);
			Icon scaledIcon = new ImageIcon(scaledImage);
			return scaledIcon;
		}
	}

}
