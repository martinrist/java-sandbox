package com.martinrist.sandbox.interviews.fibonacci;

public class FibonacciIterative {

	public static void main(String[] args) {
		
		for (int i=0; i<10; i++) {
			System.out.println(fib(i));
		}
	}
	
	
	public static int fib(int n) {
		
		int t, a = 1, b = 1;
		
		for (int i=2; i<n; i++) {
			t = a+b;
			a = b;
			b = t;
		}
		
		return b;
		
		
	}
	
}
