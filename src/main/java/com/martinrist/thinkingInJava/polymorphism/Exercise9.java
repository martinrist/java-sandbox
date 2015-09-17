package com.martinrist.thinkingInJava.polymorphism;

/**
 * Thinking in Java - 'Polymorphism' Chapter
 * Exercise 9 - Exercising Rodents
 */
public class Exercise9 {

    public static void main(String[] args) {

        Rodent[] rodents = {new Mouse(), new Mouse("Minnie"),
                new Gerbil(), new Gerbil("Geraldine"),
                new Hamster(), new Hamster("Henrietta")};

        for (Rodent r : rodents) {
            System.out.println(r);
            System.out.println("\tmakeNoise(): " + r.makeNoise());
            System.out.println("\tmove():      " + r.move());
        }
   }

}
