package com.martinrist.sandbox.swing.mouseEvents.shapes;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

public class CircleFactory implements ShapeFactory {

	@Override
	public Shape newShape(int x, int y, int width, int height) {
		return new Ellipse2D.Double(x, y, width, height);
	}

}
