package com.martinrist.thinkingInJava.typeInfo.pets;


import java.util.ArrayList;
import java.util.List;

public interface PetCreator {

    /**
     * Returns a list of the classes of all registered Pet types in the system.
     * @return List containing a Class<? extends Pet> object for each registered type
     */
    List<Class<? extends Pet>> types();

    Pet randomPet();

    Pet[] createArray(int size);

    ArrayList<Pet> arrayList(int size);
}
