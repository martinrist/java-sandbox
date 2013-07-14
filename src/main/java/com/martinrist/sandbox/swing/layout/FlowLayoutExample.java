package com.martinrist.sandbox.swing.layout;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.DefaultFrame;

public class FlowLayoutExample {

	public static void main(final String[] args) {
		new FlowLayoutExample().run();
	}

	private void run() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Frame frame = new FlowLayoutExampleFrame("Flow Layout Example");
				frame.setVisible(true);
			}
		});
	}
}

class FlowLayoutExampleFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();

	public FlowLayoutExampleFrame(final String title) {
		super(title);
		add(panel);

		addButton("Left", FlowLayout.LEFT);
		addButton("Centre", FlowLayout.CENTER);
		addButton("Right", FlowLayout.RIGHT);

	}

	private void addButton(final String title, final int align) {

		JButton button = new JButton(title);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				panel.setLayout(new FlowLayout(align));
				panel.validate();
			}
		});
		panel.add(button);
	}
}
