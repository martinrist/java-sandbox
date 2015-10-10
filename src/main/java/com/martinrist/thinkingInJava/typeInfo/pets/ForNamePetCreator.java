package com.martinrist.thinkingInJava.typeInfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNamePetCreator extends AbstractBasePetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    public ForNamePetCreator(long seed) {
        super(seed);
    }

    public ForNamePetCreator() {
        super();
    }

    private static String[] typeNames = {
            "com.martinrist.thinkingInJava.typeInfo.pets.Hamster",
            "com.martinrist.thinkingInJava.typeInfo.pets.Mouse",
            "com.martinrist.thinkingInJava.typeInfo.pets.Rat",
            "com.martinrist.thinkingInJava.typeInfo.pets.EgyptianMau",
            "com.martinrist.thinkingInJava.typeInfo.pets.Manx",
            "com.martinrist.thinkingInJava.typeInfo.pets.Cymric",
            "com.martinrist.thinkingInJava.typeInfo.pets.Mutt",
            "com.martinrist.thinkingInJava.typeInfo.pets.Pug"
    };


    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
