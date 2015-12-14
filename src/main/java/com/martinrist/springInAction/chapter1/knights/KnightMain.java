package com.martinrist.springInAction.chapter1.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Simple example of wiring up Knights using a ClassPathXmlApplicationContext.
 */
public class KnightMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/springInAction/chapter1/application-context-knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

    }
}
