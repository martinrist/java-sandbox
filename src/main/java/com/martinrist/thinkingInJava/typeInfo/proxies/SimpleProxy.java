package com.martinrist.thinkingInJava.typeInfo.proxies;

public class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }


    @Override
    public void doSomething() {
        System.out.println("In SimpleProxy.doSomething()");
        proxied.doSomething();
    }

    @Override
    public void doSomethingElse(String arg) {
        System.out.println("In SimpleProxy.doSomethingElse(" + arg + ")");
        proxied.doSomethingElse(arg);
    }
}
