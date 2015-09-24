package com.martinrist.thinkingInJava.containers;

public class RemoveToken<T> implements Token<T> {

    @Override
    public void execute(Stack<T> stack) {
        T value = stack.pop();
        System.out.print(value);
    }

    @Override
    public String toString() {
        return "RemoveToken";
    }
}
