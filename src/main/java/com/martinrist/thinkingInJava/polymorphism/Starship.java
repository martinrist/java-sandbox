package com.martinrist.thinkingInJava.polymorphism;

public class Starship {

    private AlertStatus alertStatus = new GreenAlert();
    private String name;

    public Starship(String name) {
        this.name = name;
    }

    public AlertStatus getAlertStatus() {
        return alertStatus;
    }

    @Override
    public String toString() {
        return String.format("Starship %s - Status: %s", getName(), alertStatus.getStatus());
    }

    public String getName() {
        return name;
    }

    public void increaseAlertStatus() {
        alertStatus = alertStatus.increase();
    }

    public void decreaseAlertStatus() {
        alertStatus = alertStatus.decrease();
    }

    public void resetAlertStatus() {
        alertStatus = new GreenAlert();
    }
}


