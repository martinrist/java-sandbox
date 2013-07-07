package com.martinrist.sandbox.swing.mouseEvents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.martinrist.sandbox.swing.mouseEvents.shapes.ShapeFactory;

public class MouseDrawingComponent extends JComponent {

	private final List<Shape> shapes = new ArrayList<>();
	private final ShapeFactory shapeFactory;

	private static final long serialVersionUID = 1L;
	private static final int SQUARE_SIZE = 20;

	public MouseDrawingComponent(ShapeFactory shapeFactory) {
		this.shapeFactory = shapeFactory;
		this.addMouseListener(new MouseEventHandler());
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		for (Shape shape : shapes) {
			g2.draw(shape);
		}

	}

	class MouseEventHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

			Shape shape = shapeFactory.newShape(e.getX() - (SQUARE_SIZE / 2), e.getY() - (SQUARE_SIZE / 2),
					SQUARE_SIZE, SQUARE_SIZE);
			shapes.add(shape);
			repaint();
		}

	}

}
