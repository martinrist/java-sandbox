package com.martinrist.thinkingInJava.innerClasses.factories;

public class ServiceImpl1 implements Service {

    private ServiceImpl1() {
        // prevent instantiation via private constructor
    }

    @Override
    public void method1() {
        System.out.println("In ServiceImpl1.method1()");
    }

    @Override
    public void method2() {
        System.out.println("In ServiceImpl1.method2()");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImpl1();
        }
    };
}
