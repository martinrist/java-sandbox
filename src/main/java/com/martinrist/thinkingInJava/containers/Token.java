package com.martinrist.thinkingInJava.containers;

public interface Token<T> {

    void execute(Stack<T> stack);

}
