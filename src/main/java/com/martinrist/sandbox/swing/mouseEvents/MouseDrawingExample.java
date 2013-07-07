package com.martinrist.sandbox.swing.mouseEvents;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.martinrist.sandbox.swing.mouseEvents.shapes.RandomShapeFactory;
import com.martinrist.sandbox.swing.mouseEvents.shapes.ShapeFactory;

public class MouseDrawingExample {

	public ShapeFactory shapeFactory = new RandomShapeFactory();

	public static void main(String[] args) {

		new MouseDrawingExample().run();
	}

	private void run() {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new MouseDrawingFrame("Mouse Drawing Example", shapeFactory);
				frame.setVisible(true);
			}
		});

	}

}
