package com.martinrist.thinkingInJava.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestClass {

    int id();
    String description() default "Default Test Case";

}
