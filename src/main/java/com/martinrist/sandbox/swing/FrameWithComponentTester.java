package com.martinrist.sandbox.swing;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrameWithComponentTester {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				JFrame frame = new FrameWithComponent();
				frame.setVisible(true);

			}
		});

	}
}

class FrameWithComponent extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	public FrameWithComponent() {
		super("Frame with Component");
		add(new TextComponent("This is some text"));
	}
}

class TextComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private final String content;

	public TextComponent() {
		this("");
	}

	public TextComponent(String content) {
		this.content = content;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(content, 50, 50);
	}

}