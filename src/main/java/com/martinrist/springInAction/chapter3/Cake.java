package com.martinrist.springInAction.chapter3;

import org.springframework.stereotype.Component;

@Component
public class Cake implements Dessert {

    @Override
    public void eat() {
        System.out.println("Eating cake");
    }
}
