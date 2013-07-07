package com.martinrist.sandbox.swing.mouseEvents.shapes;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;


public class SquareFactory implements ShapeFactory {

	@Override
	public Shape newShape(int x, int y, int width, int height) {

		if (width != height) {
			throw new IllegalArgumentException("Shapes must have equal height and width");
		}

		return new Rectangle2D.Double(x, y, width, height);
	}

}
