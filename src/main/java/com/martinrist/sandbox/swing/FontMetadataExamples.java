package com.martinrist.sandbox.swing;

import java.awt.GraphicsEnvironment;

public class FontMetadataExamples {

	public static void main(String[] args) {
		new FontMetadataExamples().run();
	}

	private void run() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();

		listAvailableFonts(env);
	}

	private void listAvailableFonts(GraphicsEnvironment env) {

		System.out.println("Listing all available font families:\n");

		String[] fontFamilies = env.getAvailableFontFamilyNames();
		for (String fontFamily : fontFamilies) {
			System.out.println(fontFamily);
		}

	}

}
