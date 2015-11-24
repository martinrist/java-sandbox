package com.martinrist.thinkingInJava.annotations;

@TestClass(id=2, description = "Derived Test Class")
public class DerivedTest extends BaseTest {

    @Override
    // This does not inherit any method-level annotations from BaseTest.testMethod1()
    public void testMethod1() {
        // test implementation omitted
    }

    @Override
    // This overrides the @Test annotation from BaseTest.testMethod2()
    @Test(id=2, description="Overridden description")
    public void testMethod2() {
        // test implementation omitted
    }
}
