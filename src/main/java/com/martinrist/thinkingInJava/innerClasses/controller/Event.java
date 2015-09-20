package com.martinrist.thinkingInJava.innerClasses.controller;

public abstract class Event {

    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime();
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();

}
