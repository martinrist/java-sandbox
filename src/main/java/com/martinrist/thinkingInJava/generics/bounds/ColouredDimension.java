package com.martinrist.thinkingInJava.generics.bounds;

import java.awt.*;

public class ColouredDimension<T extends Dimension & HasColour> {

    T item;

    public ColouredDimension(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color colour() {
        return item.getColour();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

}
