package com.martinrist.thinkingInJava.innerClasses.factories;

public class Factories {

    public static void main(String[] args) {

        serviceConsumer(ServiceImpl1.factory);
        serviceConsumer(ServiceImpl2.factory);

    }

    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }

}
