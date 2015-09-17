package com.martinrist.thinkingInJava.polymorphism;

import java.awt.*;

abstract class AlertStatus {

    public abstract String getStatus();
    public abstract Color getColour();
    public abstract AlertStatus increase();
    public abstract AlertStatus decrease();

}
