package com.martinrist.thinkingInJava.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {

    // Compile-time error - cannot assign ArrayList<Apple> to List<Fruit>
    // private List<Fruit> fruitList = new ArrayList<Apple>();

    // Not even if the raw types are the same
    // private ArrayList<Fruit> fruitList = new ArrayList<Apple>();

}
