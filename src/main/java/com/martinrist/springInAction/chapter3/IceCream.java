package com.martinrist.springInAction.chapter3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cold")
public class IceCream implements Dessert {

    @Override
    public void eat() {
        System.out.println("Eating ice cream");
    }
}
