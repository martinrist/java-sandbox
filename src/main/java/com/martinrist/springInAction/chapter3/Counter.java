package com.martinrist.springInAction.chapter3;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Example of a bean craeted with 'prototype' scope.  When this bean is
 * autowired from multiple locations, each gets a new instance, which therefore
 * has a different id.
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Counter {

    private static int count = 0;
    private int id = ++count;

    public int getId() {
        return id;
    }
}
