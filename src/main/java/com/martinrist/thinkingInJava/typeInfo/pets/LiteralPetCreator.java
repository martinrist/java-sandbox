package com.martinrist.thinkingInJava.typeInfo.pets;

import java.util.*;

public class LiteralPetCreator extends AbstractBasePetCreator {

    public LiteralPetCreator(long seed) {
        super(seed);
    }

    public LiteralPetCreator() {
        super();
    }

    public static final List<Class<? extends Pet>> types =
            Collections.unmodifiableList(Arrays.asList(
                    Hamster.class, Mouse.class, Rat.class,
                    EgyptianMau.class, Manx.class, Cymric.class,
                    Mutt.class, Pug.class));

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

}
