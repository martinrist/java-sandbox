package com.martinrist.sandbox.swing.mouseEvents;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
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
		MouseEventHandler handler = new MouseEventHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		for (Shape shape : shapes) {
			g2.draw(shape);
		}

	}

	class MouseEventHandler extends MouseAdapter {

		private final Cursor MOUSE_OVER_SHAPE_CURSOR = new Cursor(Cursor.CROSSHAIR_CURSOR);
		private final Cursor DEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);

		private final boolean afterFirstClick = false;

		@Override
		public void mouseClicked(MouseEvent e) {

			Shape shapeAtCursor = getShapeAtPoint(e.getPoint());

			if (shapeAtCursor != null) {
				if (e.getClickCount() == 2) {
					shapes.remove(shapeAtCursor);
				}
			} else {
				Shape shape = shapeFactory.newShape(e.getX() - (SQUARE_SIZE / 2), e.getY() - (SQUARE_SIZE / 2),
						SQUARE_SIZE, SQUARE_SIZE);
				shapes.add(shape);
			}
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {

			Point cursorPosition = e.getPoint();

			if (getShapeAtPoint(cursorPosition) != null) {
				setCursor(MOUSE_OVER_SHAPE_CURSOR);
			} else {
				setCursor(DEFAULT_CURSOR);
			}
		}

		private Shape getShapeAtPoint(Point point) {
			for (Shape shape : shapes) {
				if (shape.contains(point)) {
					return shape;
				}
			}
			return null;
		}
	}

}
