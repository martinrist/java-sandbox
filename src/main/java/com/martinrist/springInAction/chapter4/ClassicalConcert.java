package com.martinrist.springInAction.chapter4;

import org.springframework.stereotype.Component;

@Component
public class ClassicalConcert implements Performance {

    @Override
    public void perform() {
        System.out.println("Performing Concert!");
    }

}