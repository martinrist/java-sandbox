package com.martinrist.sandbox.interviews.foolist;

public class Foo {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Foo() {
		this.name = "Nameless";
	}
	
	public Foo(String _name) {
		this.name = _name;
	}
}
