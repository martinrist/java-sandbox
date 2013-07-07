package com.martinrist.sandbox.swing.mouseEvents.shapes;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class RoundRectangleFactory implements ShapeFactory {

	private final int roundingArc;

	public RoundRectangleFactory(int roundingArc) {
		this.roundingArc = roundingArc;
	}

	@Override
	public Shape newShape(int x, int y, int width, int height) {
		return new RoundRectangle2D.Double(x, y, width, height, roundingArc, roundingArc);
	}
}
