package com.martinrist.springInAction.chapter4;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConcertMain {

    private ConfigurableApplicationContext ctx;

    public ConcertMain(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    public static void main(String[] args) {

        System.out.println("Annotation configuration example");
        System.out.println("--------------------------------");
        new ConcertMain(getAnnotatedContext()).attendConcerts();

        System.out.println();
        System.out.println("XML configuration example");
        System.out.println("-------------------------");
        new ConcertMain(getXMLContext()).attendConcerts();

    }

    private void attendConcerts() {
        try {
            attendConcert("classicalConcert");
            attendConcert("dreadfulConcert");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e);
        }
    }

    public void attendConcert(String name) {

        System.out.println("Attending concert: " + name);
        Performance performance = (Performance) ctx.getBean(name);
        performance.perform();
        System.out.println("Concert finished: " + name);
        System.out.println();

    }



    public static ConfigurableApplicationContext getAnnotatedContext() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConcertConfig.class);
        ctx.refresh();
        return ctx;
    }

    public static ConfigurableApplicationContext getXMLContext() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/springInAction/chapter4/application-context-bareAudience.xml");
        return ctx;
    }

}
