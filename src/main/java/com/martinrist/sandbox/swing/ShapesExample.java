package com.martinrist.sandbox.swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ShapesExample {

	private final ShapesFrame frame = new ShapesFrame("Shapes Example");

	public static void main(String[] args) {
		new ShapesExample().run();
	}

	private void run() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ShapesFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	private final ShapesComponent shapesComponent;

	public ShapesFrame(String title) {
		super(title);
		shapesComponent = new ShapesComponent();
		this.getContentPane().setBackground(Color.ORANGE);
		add(shapesComponent);
	}

}

class ShapesComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	
		float x = getWidth() / 4.0f;
		float y = getHeight() / 4.0F;
		float w = getWidth() / 2.0F;
		float h = getHeight() / 2.0F;
		
		Point2D topLeft = new Point2D.Float(x, y);
		Point2D bottomRight = new Point2D.Float(x+w, y+h);
		
		Ellipse2D ellipse = new Ellipse2D.Float();
		ellipse.setFrameFromDiagonal(topLeft, bottomRight);
		
		g2.setPaint(new GradientPaint(topLeft, Color.BLUE, bottomRight, Color.GREEN));
		g2.fill(ellipse);
		
		Rectangle2D ellipseBound = ellipse.getBounds2D();
		g2.setColor(Color.RED);
		g2.draw(ellipseBound);
	}

}