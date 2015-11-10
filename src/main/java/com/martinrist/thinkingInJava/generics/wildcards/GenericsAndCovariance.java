package com.martinrist.thinkingInJava.generics.wildcards;


import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

    public static void main(String[] args) {

        // We know we can't do this...
        // List<Fruit> fruitList = new ArrayList<Apple>();

        // This works - fruitList is a reference to a List whose
        // type parameter is any type inherited from Fruit
        List<? extends Fruit> fruitList = new ArrayList<Apple>();

        // But we can't add anything to it...
        // fruitList.add(new Apple());
        // fruitList.add(new Orange());
        // fruitList.add(new Fruit());

        // ... except null
        fruitList.add(null);

        // But we *do* know that we get back a Fruit
        Fruit fruit = fruitList.get(0);

        // We can, however, call methods that take an Object as an argument
        fruitList.contains(new Apple());
        fruitList.indexOf(new Apple());


    }

}
