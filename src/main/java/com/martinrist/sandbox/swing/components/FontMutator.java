package com.martinrist.sandbox.swing.components;

import java.awt.Font;

public abstract class FontMutator {

	private String name;
	protected int style;
	protected int size;

	public Font changeFont(Font currentFont) {

		name = currentFont.getName();
		style = currentFont.getStyle();
		size = currentFont.getSize();

		changeFontAttributes();

		return new Font(name, style, size);
	}

	public abstract void changeFontAttributes();

}
