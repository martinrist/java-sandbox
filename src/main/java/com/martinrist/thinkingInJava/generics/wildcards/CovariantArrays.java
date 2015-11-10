package com.martinrist.thinkingInJava.generics.wildcards;

public class CovariantArrays {

    public static void main(String[] args) {

        Fruit[] fruit = new Apple[10];      // Can assign array of derived class to reference of base
        fruit[0] = new Apple();             // OK
        fruit[1] = new Jonathan();          // Can add derived classes

        try {
            fruit[2] = new Fruit();         // OK at compile-time by ArrayStoreException at runtime
        } catch (ArrayStoreException ase) {
            // expected outcome
            ase.printStackTrace();
        }

        try {
            fruit[2] = new Orange();        // OK at compile-time by ArrayStoreException at runtime
        } catch (ArrayStoreException ase) {
            // expected outcome
            ase.printStackTrace();
        }

        // fruit[3] = new Integer(1);       // Compile-time error
    }

}



