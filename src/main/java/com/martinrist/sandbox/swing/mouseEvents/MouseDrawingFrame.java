package com.martinrist.sandbox.swing.mouseEvents;

import com.martinrist.sandbox.swing.DefaultFrame;
import com.martinrist.sandbox.swing.mouseEvents.shapes.ShapeFactory;

public class MouseDrawingFrame extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	public MouseDrawingFrame(String title, ShapeFactory shapeFactory) {
		super(title);
		add(new MouseDrawingComponent(shapeFactory));

	}
}
