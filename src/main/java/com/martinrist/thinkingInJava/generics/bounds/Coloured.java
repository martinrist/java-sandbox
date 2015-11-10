package com.martinrist.thinkingInJava.generics.bounds;

import java.awt.*;

public class Coloured<T extends HasColour> {

    T item;

    Coloured(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color colour() {
        return item.getColour();
    }

}
