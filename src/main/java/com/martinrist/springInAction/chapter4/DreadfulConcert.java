
package com.martinrist.springInAction.chapter4;

import org.springframework.stereotype.Component;

@Component
public class DreadfulConcert implements Performance {

    @Override
    public void perform() {
        System.out.println("Starting Concert!");
        System.out.println("Something's gone wrong...");
        throw new RuntimeException("Everyone's forgotten how to play!");
    }

}