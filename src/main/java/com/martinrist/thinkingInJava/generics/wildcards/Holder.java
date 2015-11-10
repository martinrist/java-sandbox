package com.martinrist.thinkingInJava.generics.wildcards;

public class Holder<T> {

    private T value;

    public Holder() { }

    public Holder(T val) { this.value = val; }

    public void set(T val) { this.value = val; }

    public T get() { return this.value; }

    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {

        // This is all fine, because we're using a specific (non-wildcarded) reference
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple a = appleHolder.get();
        appleHolder.set(a);

        // Cannot upcast unless we use an upper-bounded wildcard
        // Holder<Fruit> fruitHolder = appleHolder;
        Holder<? extends Fruit> fruitHolder = appleHolder;

        // This works, and we know we can get back a Fruit reference...
        Fruit p = fruitHolder.get();
        // ... the runtime-type of which is Apple
        System.out.println(p.getClass().getSimpleName());

        // ... but this doesn't, because `set` takes a type parameter
        // fruitHolder.set(p);

        // However, because `equals` takes an Object, it can be called.
        System.out.println(fruitHolder.equals(p));

    }
}
