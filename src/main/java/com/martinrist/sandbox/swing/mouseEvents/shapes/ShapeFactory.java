package com.martinrist.sandbox.swing.mouseEvents.shapes;

import java.awt.Shape;

public interface ShapeFactory {

	public Shape newShape(int x, int y, int width, int height);

}
