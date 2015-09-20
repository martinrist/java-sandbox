package com.martinrist.thinkingInJava.interfaces.factories;

public class ServiceFactoryImpl1 implements ServiceFactory {

    @Override
    public Service getService() {
        return new ServiceImpl1();
    }
}
