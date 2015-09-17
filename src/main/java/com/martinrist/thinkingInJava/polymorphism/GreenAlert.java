package com.martinrist.thinkingInJava.polymorphism;

import java.awt.*;

class GreenAlert extends AlertStatus {

    @Override
    public String getStatus() {
        return "Green Alert!";
    }

    @Override
    public Color getColour() {
        return Color.GREEN;
    }

    @Override
    public AlertStatus increase() {
        return new YellowAlert();
    }

    @Override
    public AlertStatus decrease() {
        // Can't decrease a Green alert
        return this;
    }

}
