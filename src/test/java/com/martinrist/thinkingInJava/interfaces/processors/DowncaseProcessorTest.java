package com.martinrist.thinkingInJava.interfaces.processors;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)

public class DowncaseProcessorTest {

    Downcase proc = new Downcase();

    @DataPoints
    public static String[] data = new String[] {"", "foo", "foo bar", "foo123bar",
            "foo 123 bar", "foo !@£ bar", "foo \n\t\b bar"};


    @Test
    public void test_UpcaseProcessor_HasCorrectName() {
        assertThat(proc.name(), is("Downcase"));
    }

    @Theory
    public void test_UpcaseProcessor_ReturnsUpperCase(String input) {
        assertThat(proc.process(input), is(input.toLowerCase()));
    }


}
