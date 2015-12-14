package com.martinrist.springInAction.chapter2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompactDiscMain {

    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/springInAction/chapter2/application-context-compactDisc.xml")) {
            System.out.println("Getting CD from XML context");
            getAndPlayCD(ctx);
        }


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(CDPlayerConfig.class);
        ctx.refresh();
        System.out.println("Getting CD from JavaConfig context");
        getAndPlayCD(ctx);
    }




    public static void getAndPlayCD(ApplicationContext ctx) {

        CompactDisc cd = ctx.getBean(CompactDisc.class);
        cd.play();
    }
}
