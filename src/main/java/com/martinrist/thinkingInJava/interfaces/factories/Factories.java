package com.martinrist.thinkingInJava.interfaces.factories;

public class Factories {

    public static void main(String[] args) {

        serviceConsumer(new ServiceFactoryImpl1());
        serviceConsumer(new ServiceFactoryImpl2());

    }

    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }

}
