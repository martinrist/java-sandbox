package com.martinrist.thinkingInJava.typeInfo.proxies;

public class RealObject implements Interface {

    @Override
    public void doSomething() {
        System.out.println("In RealObject.doSomething()");
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("In RealObject.doSomething(" + arg + ")");
    }
}
