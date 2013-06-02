package com.martinrist.sandbox.lang;

public class ClassWithPrivateField {

	private String name;

	public ClassWithPrivateField(String name) {
		this.name = name;
	}

	@SuppressWarnings("unused")
	private void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
