package com.martinrist.thinkingInJava.polymorphism;

import java.awt.*;

class RedAlert extends AlertStatus {

    @Override
    public String getStatus() {
        return "Red Alert!";
    }

    @Override
    public Color getColour() {
        return Color.RED;
    }

    @Override
    public AlertStatus increase() {
        // Can't increase a Red Alert
        return this;
    }

    @Override
    public AlertStatus decrease() {
        return new YellowAlert();
    }


}
