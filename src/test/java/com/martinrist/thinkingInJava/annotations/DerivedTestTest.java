package com.martinrist.thinkingInJava.annotations;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


public class DerivedTestTest {

    @Test
    public void testClass_IsAnnotatedWithTestClass() {
        assertThat(getTestClassAnnotation(), notNullValue());
    }

    @Test
    public void testClass_HasCorrectAnnotationAttributes() {
        TestClass ann = getTestClassAnnotation();
        assertThat(ann.id(), is(2));
        assertThat(ann.description(), is("Derived Test Class"));
    }

    @Test
    public void testMethod1_DoesNotInheritTestAnnotated() throws NoSuchMethodException {
        assertThat(getTestAnnotation("testMethod1"), nullValue());
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
    public void testMethod2_HasCorrectDescription() throws NoSuchMethodException {
        com.martinrist.thinkingInJava.annotations.Test testMethod = getTestAnnotation("testMethod2");
        assertThat(testMethod.description(), is("Overridden description"));
    }

    private com.martinrist.thinkingInJava.annotations.TestClass getTestClassAnnotation() {
        return DerivedTest.class.getAnnotation(TestClass.class);
    }

    private com.martinrist.thinkingInJava.annotations.Test getTestAnnotation(String methodName) throws NoSuchMethodException {
        Method method = DerivedTest.class.getDeclaredMethod(methodName);
        return method.getDeclaredAnnotation(com.martinrist.thinkingInJava.annotations.Test.class);
    }


}