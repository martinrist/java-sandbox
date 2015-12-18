package com.martinrist.springInAction.chapter4;

import org.aspectj.lang.annotation.*;

/**
 * Aspect that represents an Audience for a performance.  The audience has
 * various interactions with the performance depending on its outcome.
 */
@Aspect
public class Audience {

    // This defines the reusable pointcut expression can be used elsewhere
    @Pointcut("execution(* com.martinrist.springInAction.chapter4.Performance.perform(..))")
    public void performance() {}

    // This uses an explicit pointcut expression
    @Before("execution(* com.martinrist.springInAction.chapter4.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    // Uses the performance() pointcut expression defined above
    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

}
