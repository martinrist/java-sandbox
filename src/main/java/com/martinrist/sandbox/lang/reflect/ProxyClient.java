package com.martinrist.sandbox.lang.reflect;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyClient {

	public static void main(String[] args) {

		Object[] integers = new Object[10];

		for (int i = 0; i < integers.length; i++) {
			MethodTraceHandler h = new MethodTraceHandler(i);
			integers[i] = Proxy.newProxyInstance(null, new Class[] {}, h);
		}

		System.out.println(Arrays.toString(integers));
	}
}
