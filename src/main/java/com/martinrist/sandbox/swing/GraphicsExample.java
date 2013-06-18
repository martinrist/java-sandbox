package com.martinrist.sandbox.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GraphicsExample {

	private final GraphicsFrame frame = new GraphicsFrame("Graphics Example");

	public static void main(String[] args) {
		new GraphicsExample().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});

		for (int count = 1; count < 10; count++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

			frame.getGraphicsComponent().incrementCounter();

			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.repaint();
				}
			});
		}
	}
}

class GraphicsFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	private final GraphicsComponent graphicsComponent;

	public GraphicsComponent getGraphicsComponent() {
		return graphicsComponent;
	}

	public GraphicsFrame(String title) {
		super(title);
		graphicsComponent = new GraphicsComponent();
		add(graphicsComponent);
	}

}

class GraphicsComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	private int counter = 1;

	public int getCounter() {
		return counter;
	}

	public void incrementCounter() {
		counter++;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("Counter = " + counter, 0, 50);
	}

}