package com.martinrist.springInAction.chapter3;

import org.springframework.stereotype.Component;

@Component
public class Cookies implements Dessert {

    @Override
    public void eat() {
        System.out.println("Eating cookies");
    }
}
