package com.martinrist.thinkingInJava.interfaces.processors;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

public class CharacterPairSwapperTest {

    CharacterPairSwapper testObject = new CharacterPairSwapper();

    @Test
    public void test_SwapPairs_WorksOnEmptyStrings() {
        assertThat(testObject.swapPairs(""), isEmptyString());
    }

    @Test
    public void test_SwapPairs_OnSingleChar_ReturnsSameString() {
        for (char c = 0; c < Character.MAX_VALUE; c++) {
            String s = "" + c;
            assertThat(testObject.swapPairs(s), is(s));
        }
    }

    @Test
    public void test_SwapPairs_OnTwoChars_ReturnsCorrectValue() {

        assertThat(testObject.swapPairs("to"), is("ot"));
        assertThat(testObject.swapPairs("ab"), is("ba"));
        assertThat(testObject.swapPairs("aa"), is("aa"));
        assertThat(testObject.swapPairs("!#"), is("#!"));

    }

    @Test
    public void test_SwapPairs_OnThreeChars_LeavesLastCharUnchanged() {

        assertThat(testObject.swapPairs("abc"), is("bac"));
        assertThat(testObject.swapPairs("bba"), is("bba"));
        assertThat(testObject.swapPairs("ccc"), is("ccc"));
        assertThat(testObject.swapPairs("!#$"), is("#!$"));

    }


}