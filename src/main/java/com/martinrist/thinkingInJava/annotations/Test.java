package com.martinrist.thinkingInJava.annotations;

import java.lang.annotation.*;

// The @Test tag from TiJ Chapter 'Annotations'
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

    int id();
    String description() default "No description";

}
