package com.martinrist.thinkingInJava.generics.wildcards;


import java.util.ArrayList;
import java.util.List;

public class GenericsAndContravariance {

    public static void main(String[] args) {

        // We know we can't do this...
        // List<Fruit> fruitList = new ArrayList<Apple>();

        // This works - fruitList is a reference to a List whose
        // type parameter is any type which is a supertype of Apple
        List<? super Apple> fruitList = new ArrayList<Fruit>();

        // So we can add Apples to it, or any subclasses of Apple...
        fruitList.add(new Apple());
        fruitList.add(new Jonathan());

        // ...but not Oranges or Fruit, because that could allow us
        // to add other subtypes of Orange, or other Fruits
        // fruitList.add(new Orange());
        // fruitList.add(new Fruit());

        // However, all we can get back is an Object reference, because we don't know any more
        // Fruit fruit = fruitList.get(0);
        Object fruit = fruitList.get(0);

    }

}
