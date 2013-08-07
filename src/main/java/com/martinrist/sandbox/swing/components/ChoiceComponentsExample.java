package com.martinrist.sandbox.swing.components;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.DefaultFrame;

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

@SuppressWarnings("serial")
class ChoiceComponentsFrame extends DefaultFrame {

	private static final int DEFAULT_FONT_SIZE = 12;
	private static final String TEXT_CONTENT = "The quick brown fox jumps over the lazy dog";

	private final JLabel textLabel;
	private final JCheckBox boldCheckBox;
	private final JCheckBox italicCheckBox;

	public ChoiceComponentsFrame(final String title) {

		super(title);

		textLabel = new JLabel(TEXT_CONTENT, SwingConstants.CENTER);
		textLabel.setFont(new Font("SansSerif", Font.PLAIN, DEFAULT_FONT_SIZE));
		add(textLabel, BorderLayout.CENTER);

		JPanel checkBoxPanel = new JPanel();
		add(checkBoxPanel, BorderLayout.NORTH);

		boldCheckBox = new JCheckBox(new BoldAction("Bold"));
		checkBoxPanel.add(boldCheckBox);
		italicCheckBox = new JCheckBox(new ItalicAction("Italic"));
		checkBoxPanel.add(italicCheckBox);

	}

	class BoldAction extends AbstractAction {

		public BoldAction(final String label) {
			putValue(NAME, label);
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			Font currentFont = textLabel.getFont();
			String currentName = currentFont.getName();
			int currentStyle = currentFont.getStyle();
			int currentSize = currentFont.getSize();

			int newStyle = currentStyle;

			if (boldCheckBox.isSelected()) {
				newStyle += Font.BOLD;
			} else {
				newStyle -= Font.BOLD;
			}
			textLabel.setFont(new Font(currentName, newStyle, currentSize));
		}
	}

	class ItalicAction extends AbstractAction {

		public ItalicAction(final String label) {
			putValue(NAME, label);
		}

		@Override
		public void actionPerformed(final ActionEvent e) {
			Font currentFont = textLabel.getFont();
			String currentName = currentFont.getName();
			int currentStyle = currentFont.getStyle();
			int currentSize = currentFont.getSize();

			int newStyle = currentStyle;

			if (italicCheckBox.isSelected()) {
				newStyle += Font.ITALIC;
			} else {
				newStyle -= Font.ITALIC;
			}
			textLabel.setFont(new Font(currentName, newStyle, currentSize));
		}

	}

}
