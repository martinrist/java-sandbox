package com.martinrist.springInAction.chapter3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cold")
@Fruity
public class Popsicle implements Dessert {

    @Override
    public void eat() {
        System.out.println("Eating popsicle");
    }
}
