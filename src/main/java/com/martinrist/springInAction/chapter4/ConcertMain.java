package com.martinrist.springInAction.chapter4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConcertMain {

    static AnnotationConfigApplicationContext ctx;

    static {
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConcertConfig.class);
        ctx.refresh();
    }

    public static void main(String[] args) {

        try {
            attendConcert("classicalConcert");
            attendConcert("dreadfulConcert");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e);
        }

    }

    public static void attendConcert(String name) {

        System.out.println("Attending concert: " + name);
        Performance performance = (Performance) ctx.getBean(name);
        performance.perform();
        System.out.println("Concert finished: " + name);
        System.out.println();

    }

}
