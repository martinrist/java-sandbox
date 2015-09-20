package com.martinrist.thinkingInJava.innerClasses.factories;

public class ServiceImpl2 implements Service {

    private ServiceImpl2() {
        // prevent instantiation via private constructor
    }

    @Override
    public void method1() {
        System.out.println("In ServiceImpl2.method1()");
    }

    @Override
    public void method2() {
        System.out.println("In ServiceImpl2.method2()");
    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ServiceImpl2();
        }
    };
}
