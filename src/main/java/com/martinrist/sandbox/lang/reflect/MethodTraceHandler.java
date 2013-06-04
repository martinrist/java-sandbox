package com.martinrist.sandbox.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTraceHandler implements InvocationHandler {

	Object target;

	public MethodTraceHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.format("Before method : %s(%s)\n", method.getName(), Arrays.toString(args));
		Object result = method.invoke(target, args);
		System.out.format("After method : %s\n", method.getName());
		return result;
	}
}
