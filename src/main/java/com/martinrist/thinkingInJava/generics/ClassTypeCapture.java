package com.martinrist.thinkingInJava.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to demonstrate the use of a 'class tag' to work around
 * the lack of support for instanceof with generics.
 */
public class ClassTypeCapture<T> {

    Map<String,Class<?>> types = new HashMap<>();

    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Class<?> kind) {
        types.put(typeName, kind);
    }

    public Object createNew(String typename) throws Exception {

        Class<?> kind = types.get(typename);
        if (kind == null) {
            throw new IllegalArgumentException("Unable to find type name " + typename + " in supported types");
        } else {
            return kind.newInstance();
        }

    }

}

class Building {}

class House extends Building {}
