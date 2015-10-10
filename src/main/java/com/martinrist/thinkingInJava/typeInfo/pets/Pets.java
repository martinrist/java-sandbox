package com.martinrist.thinkingInJava.typeInfo.pets;

import java.util.ArrayList;

public class Pets {

    public final AbstractBasePetCreator creator;

    public Pets(AbstractBasePetCreator creator) {
        this.creator = creator;
    }

    public Pet RandomPet() {
        return creator.randomPet();
    }

    public Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }


}
