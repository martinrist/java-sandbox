package com.martinrist.sandbox.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.Transient;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ImageExample {

	public static void main(String[] args) {

		new ImageExample().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				ImageFrame frame = new ImageFrame("Image Example");
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setVisible(true);

			}
		});
	}
}

class ImageFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	JComponent imageComponent;

	public ImageFrame(String title) {

		super(title);
		imageComponent = new ImageComponent();
		add(imageComponent);
		pack();

	}
}

class ImageComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final String IMAGE_LOCATION = "/com/martinrist/sandbox/swing/background.jpg";

	private final Image img;

	public ImageComponent() {
		URL imageUrl = this.getClass().getResource(IMAGE_LOCATION);
		ImageIcon imgIcon = new ImageIcon(imageUrl);
		img = imgIcon.getImage();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	@Override
	@Transient
	public Dimension getPreferredSize() {
		return new Dimension(img.getWidth(null), img.getHeight(null));
	}
}