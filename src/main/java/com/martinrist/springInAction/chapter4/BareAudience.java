package com.martinrist.springInAction.chapter4;

import org.aspectj.lang.annotation.*;

/**
 * Class that represents an Audience for a performance.  This is functionally
 * equivalent to Audience but has had all the AspectJ annotations stripped out
 * of it.  All aspect configuration is done in XML.
 */
@Aspect
public class BareAudience {

    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    public void takeSeats() {
        System.out.println("Taking seats");
    }

    public void applaud() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

}
