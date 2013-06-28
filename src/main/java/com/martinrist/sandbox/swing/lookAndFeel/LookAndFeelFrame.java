package com.martinrist.sandbox.swing.lookAndFeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.martinrist.sandbox.swing.DefaultFrame;

public class LookAndFeelFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	private final JPanel buttonPanel = new JPanel();

	public LookAndFeelFrame(String title) {
		super(title);
		add(buttonPanel);
		createButtons();
		pack();
	}

	private void createButtons() {

		LookAndFeelInfo[] lookAndFeels = UIManager.getInstalledLookAndFeels();

		for (int i = 0; i < lookAndFeels.length; i++) {
			LookAndFeelInfo lafi = lookAndFeels[i];
			buttonPanel.add(makeButton(lafi));
		}

	}

	private JButton makeButton(LookAndFeelInfo lafi) {
		String className = lafi.getClassName();
		String lafName = lafi.getName();

		JButton button = new JButton(lafName);

		button.addActionListener(new LAFButtonAction(className));
		return button;
	}

	class LAFButtonAction implements ActionListener {

		private final String className;

		public LAFButtonAction(String className) {
			this.className = className;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				UIManager.setLookAndFeel(className);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			SwingUtilities.updateComponentTreeUI(LookAndFeelFrame.this);
		}
	}

}