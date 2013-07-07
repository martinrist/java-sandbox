package com.martinrist.sandbox.swing.mouseEvents.shapes;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomShapeFactory implements ShapeFactory {

	List<ShapeFactory> factories = new ArrayList<>();

	{
		factories.add(new CircleFactory());
		factories.add(new SquareFactory());
		factories.add(new RoundRectangleFactory(10));
	}

	Random rand = new Random();

	@Override
	public Shape newShape(int x, int y, int width, int height) {

		int typeIndex = rand.nextInt(factories.size());
		ShapeFactory factory = factories.get(typeIndex);
		return factory.newShape(x, y, width, height);

	}
}
