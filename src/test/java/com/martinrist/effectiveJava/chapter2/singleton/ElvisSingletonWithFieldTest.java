package com.martinrist.effectiveJava.chapter2.singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class ElvisSingletonWithFieldTest {

    @Test
    public void testCanCreateSecondInstanceUsingReflection() throws Exception {
        
        ElvisSingletonWithField singleton = ElvisSingletonWithField.INSTANCE;

        Constructor<ElvisSingletonWithField> privateConstructor = ElvisSingletonWithField.class
                .getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        ElvisSingletonWithField newInstance = privateConstructor.newInstance();

        assertThat(singleton, not(sameInstance(newInstance)));

    }
}