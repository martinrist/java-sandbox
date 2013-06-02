package com.martinrist.sandbox.lang.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

import com.martinrist.sandbox.lang.ClassWithPrivateField;

public class MethodTest {
	@Test(expected = IllegalAccessException.class)
	public void testAccessingPrivateMethodThrowsException() throws Exception {
		ClassWithPrivateField obj = new ClassWithPrivateField("Martin");
		Method privateMethod = ClassWithPrivateField.class.getDeclaredMethod("setName", String.class);
		privateMethod.invoke(obj, "Nicola");
	}

}
