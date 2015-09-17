package com.martinrist.thinkingInJava.polymorphism;

/**
 * Thinking in Java - 'Polymorphism' Chapter
 * Exercise 16 - Spaceships
 */
public class Exercise16 {

    public static void main(String[] args) {

        Starship enterprise = new Starship("Enterprise");
        Starship deathStar = new Starship("Death Star");

        printShipStatus(enterprise, deathStar);

        System.out.println("Ships encounter each other and increase alert level");
        enterprise.increaseAlertStatus();
        deathStar.increaseAlertStatus();
        printShipStatus(enterprise, deathStar);

        System.out.println("Death Star destroys a major Enterprise subsystem");
        System.out.println("Enterprise increases alert level");
        enterprise.increaseAlertStatus();
        printShipStatus(enterprise, deathStar);

        System.out.println("Enterprise engages warp to escape annihilation");
        System.out.println("Enterprise decreases alert level");
        System.out.println("Death Star resets alert level");
        enterprise.decreaseAlertStatus();
        deathStar.resetAlertStatus();
        printShipStatus(enterprise, deathStar);

    }

    private static void printShipStatus(Starship... ships) {
        System.out.println();
        System.out.println("Ship status:");
        System.out.println("------------");

        for (Starship s : ships) {
            System.out.println(s);
        }

        System.out.println();
    }

}

