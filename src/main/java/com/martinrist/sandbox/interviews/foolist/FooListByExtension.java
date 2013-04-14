package com.martinrist.sandbox.interviews.foolist;

import java.util.ArrayList;


@SuppressWarnings({ "serial", "rawtypes" })
public class FooListByExtension extends ArrayList {

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(Object o) {
		
		if (o instanceof Foo)
		{
			return super.add(o);
		}
		else
			return false;
	}

	// I can do this, as I'm changing the signature, so it's an overload
	@SuppressWarnings("unchecked")
	public boolean add(Foo o) {
		
		if (o instanceof Foo)
		{
			return super.add(o);
		}
		else
			return false;
	}
	
	@Override
	public Foo get(int index) {
		return (Foo) super.get(index);
	}
	
	
	
}
