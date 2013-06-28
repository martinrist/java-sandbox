package com.martinrist.sandbox.swing.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.martinrist.sandbox.swing.DefaultFrame;

public class ActionListenerExample {

	private static final String MOTIF_LOOK_AND_FEEL = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	private static final String METAL_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	private static final String WINDOWS_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(WINDOWS_LOOK_AND_FEEL);
		} catch (Exception e) {
			e.printStackTrace();
		}

		new ActionListenerExample().run();

	}

	private void run() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ActionListenerFrame frame = new ActionListenerFrame("Button Example");
				frame.setVisible(true);
			}
		});

	}
}

class ActionListenerFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	private final JPanel buttonPanel = new JPanel();

	private final JButton helloButton = new JButton("Say hello");
	private final JButton goodbyeButton = new JButton("Say goodbye");
	private final JLabel textLabel = new JLabel();

	public ActionListenerFrame(String name) {
		super(name);

		helloButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(Color.GREEN);
				goodbyeButton.setEnabled(true);
				helloButton.setEnabled(false);
				JOptionPane.showMessageDialog(ActionListenerFrame.this, "Hello!");
			}
		});

		goodbyeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(Color.RED);
				goodbyeButton.setEnabled(false);
				helloButton.setEnabled(true);
				JOptionPane.showMessageDialog(ActionListenerFrame.this, "Goodbye!");
			}
		});

		add(buttonPanel);
		buttonPanel.add(helloButton);
		buttonPanel.add(goodbyeButton);
		buttonPanel.add(textLabel);

	}

}