package com.martinrist.sandbox.interviews.foolist;

import java.util.ArrayList;
import java.util.List;

public class FooListByComposition {

	@SuppressWarnings("rawtypes")
	private List _list = new ArrayList();
	
	@SuppressWarnings("unchecked")
	public boolean add(Foo f) {
		return _list.add(f);
	}
	
	public Foo get(int index) {
		return (Foo) _list.get(index);
	}
	
}
