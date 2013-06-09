package com.martinrist.sandbox.swing;

import javax.swing.JFrame;

public class DefaultFrame extends JFrame {

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public DefaultFrame() {
		this("");
	}

	public DefaultFrame(String title) {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(title);
	}
}
