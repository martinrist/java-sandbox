package com.martinrist.sandbox.swing.components;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.DefaultFrame;

public class TextInputExample {

	public static void main(final String[] args) {
		new TextInputExample().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Frame frame = new TextInputFrame("Text Input Examples");
				frame.setVisible(true);
				frame.pack();
			}
		});
	}
}

@SuppressWarnings("serial")
class TextInputFrame extends DefaultFrame {

	private final JPanel buttonPanel = new JPanel();
	private final JTextField textField = new JTextField("Enter some text...", 20);
	private final JTextArea textArea = new JTextArea("Enter some more text...", 10, 20);

	public TextInputFrame(final String title) {

		super(title);

		JPanel textFieldPanel = new JPanel();
		textFieldPanel.add(new JLabel("Text:", SwingConstants.RIGHT));
		textFieldPanel.add(textField);
		add(textFieldPanel, BorderLayout.NORTH);

		JPanel textAreaPanel = new JPanel();
		textAreaPanel.add(new JLabel("More Text:", SwingConstants.RIGHT));
		textAreaPanel.add(textArea);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textAreaPanel);
		add(scrollPane, BorderLayout.CENTER);

		add(buttonPanel, BorderLayout.SOUTH);
		addButton(IncreaseWidthAction.class, "Wider");
		addButton(GoButtonAction.class, "Go!");
		addButton(DecreaseWidthAction.class, "Narrower");

	}

	private void addButton(final Class<?> actionClass, final String title) {

		Action action;
		try {
			Constructor<?> ctor = actionClass.getDeclaredConstructor(TextInputFrame.class);
			action = (Action) ctor.newInstance(this);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
			return;
		}
		action.putValue(Action.NAME, title);
		JButton button = new JButton(action);
		buttonPanel.add(button);
	}

	class GoButtonAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent e) {
			String text = String.format("You entered '%s' into a text field of width %d", textField.getText(),
					textField.getColumns());
			JOptionPane.showMessageDialog(null, text);

			text = String.format("You also entered '%s' into a text area of width %d x %d", textArea.getText(),
					textArea.getColumns(), textArea.getRows());
			JOptionPane.showMessageDialog(null, text);
		}
	}

	class IncreaseWidthAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent e) {
			textField.setColumns(textField.getColumns() + 1);
			textArea.setColumns(textArea.getColumns() + 1);
			revalidate();
			pack();
		}

	}

	class DecreaseWidthAction extends AbstractAction {
		@Override
		public void actionPerformed(final ActionEvent e) {
			int currentSize = textField.getColumns();
			if (currentSize > 1) {
				textField.setColumns(textField.getColumns() - 1);
				textArea.setColumns(textArea.getColumns() - 1);
				revalidate();
				pack();
			}
		}

	}
}
