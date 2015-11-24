package com.martinrist.thinkingInJava.annotations;

@TestClass(id=1)
public class BaseTest {

    // This annotation explicitly specifies the value for description
    @Test(id=1, description = "Test one")
    public void testMethod1() {
        // test implementation omitted
    }

    // This annotation relies on the default value for description
    @Test(id=2)
    public void testMethod2() {
        // test implementation omitted
    }

    // This method is not annotated
    public void testMethod3() {
        // test implementation omitted
    }
}
