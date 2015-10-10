package com.martinrist.thinkingInJava.typeInfo.proxies;

public class SimpleProxyDemo {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.doSomethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
