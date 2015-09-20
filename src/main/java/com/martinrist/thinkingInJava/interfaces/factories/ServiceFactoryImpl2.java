package com.martinrist.thinkingInJava.interfaces.factories;

public class ServiceFactoryImpl2 implements ServiceFactory {

    @Override
    public Service getService() {
        return new ServiceImpl2();
    }
}
