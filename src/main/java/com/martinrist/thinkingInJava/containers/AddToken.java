package com.martinrist.thinkingInJava.containers;

public class AddToken<T> implements Token<T> {

    private T value;

    public AddToken(T value) {
        this.value = value;
    }

    @Override
    public void execute(Stack<T> stack) {
        stack.push(value);
    }

    @Override
    public String toString() {
        return "AddToken: " + value;
    }
}
