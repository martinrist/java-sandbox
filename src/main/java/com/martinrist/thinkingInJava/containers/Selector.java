package com.martinrist.thinkingInJava.containers;

interface Selector {

    boolean end();
    Object current();
    void next();

}
