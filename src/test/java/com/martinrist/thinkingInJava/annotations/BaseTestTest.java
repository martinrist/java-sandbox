package com.martinrist.thinkingInJava.annotations;

import org.hamcrest.Matchers;
import org.junit.*;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class BaseTestTest {

    @Test
    public void testClass_IsAnnotatedWithTestClass() {
        assertThat(getTestClassAnnotation(), notNullValue());
    }

    @Test
    public void testClass_HasCorrectAnnotationAttributes() {
        TestClass ann = getTestClassAnnotation();
        assertThat(ann.id(), is(1));
        assertThat(ann.description(), is("Default Test Case"));
    }

    @Test
    public void testMethod1_IsAnnotatedWithTest() throws NoSuchMethodException {
        assertThat(getTestAnnotation("testMethod1"), notNullValue());
    }

    @Test
    public void testMethod1_HasCorrectAnnotationAttributes() throws NoSuchMethodException {
        com.martinrist.thinkingInJava.annotations.Test testMethod = getTestAnnotation("testMethod1");
        assertThat(testMethod.id(), is(1));
        assertThat(testMethod.description(), is("Test one"));
    }

    @Test
    public void testMethod2_IsAnnotatedWithTest() throws NoSuchMethodException {
        assertThat(getTestAnnotation("testMethod2"), notNullValue());
    }

    @Test
    public void testMethod2_HasCorrectId() throws NoSuchMethodException {
        com.martinrist.thinkingInJava.annotations.Test testMethod = getTestAnnotation("testMethod2");
        assertThat(testMethod.id(), is(2));
    }

    @Test
    public void testMethod2_HasCorrectlyDefaultedDescription() throws NoSuchMethodException {
        com.martinrist.thinkingInJava.annotations.Test testMethod = getTestAnnotation("testMethod2");
        assertThat(testMethod.description(), is("No description"));
    }

    @Test
    public void testMethod3_NotAnnotatedWithTest() throws NoSuchMethodException {
        assertThat(getTestAnnotation("testMethod3"), nullValue());
    }

    private com.martinrist.thinkingInJava.annotations.TestClass getTestClassAnnotation() {
        return BaseTest.class.getAnnotation(TestClass.class);
    }

    private com.martinrist.thinkingInJava.annotations.Test getTestAnnotation(String methodName) throws NoSuchMethodException {
        Method method = BaseTest.class.getDeclaredMethod(methodName);
        return method.getDeclaredAnnotation(com.martinrist.thinkingInJava.annotations.Test.class);
    }

}