package com.martinrist.thinkingInJava.typeInfo.pets;

import java.util.*;

public abstract class AbstractBasePetCreator implements PetCreator {

    private final Random rand;

    protected AbstractBasePetCreator(long seed) {
        this.rand = new Random(seed);
    }

    protected AbstractBasePetCreator() {
        rand = new Random();
    }

    /**
     * Creates a random pet from one of the pet types returned by types()
     * @return A random class of one of the registered types.
     */
    @Override
    public Pet randomPet() {

        int n = rand.nextInt(types().size());

        try {
            return types().get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Pet[] createArray(int size) {

        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;

    }

    @Override
    public ArrayList<Pet> arrayList(int size) {

        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;

    }

}
