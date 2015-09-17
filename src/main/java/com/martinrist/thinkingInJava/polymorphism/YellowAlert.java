package com.martinrist.thinkingInJava.polymorphism;

import java.awt.*;

class YellowAlert extends AlertStatus {

    @Override
    public String getStatus() {
        return "Yellow Alert!";
    }

    @Override
    public Color getColour() {
        return Color.YELLOW;
    }

    @Override
    public AlertStatus increase() {
        return new RedAlert();
    }

    @Override
    public AlertStatus decrease() {
        return new GreenAlert();
    }

}
