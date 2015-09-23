package com.martinrist.thinkingInJava.containers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.*;

public class ListBackedGeneratorTest {

    private ListBackedGenerator<String> singleItemGenerator = new ListBackedGenerator<>(Collections.singletonList("Darth Vader"));
    private ListBackedGenerator<String> twoItemGenerator = new ListBackedGenerator<>(Arrays.asList("Han Solo", "Luke Skywalker"));



    @Test
    public void test_GivenEmptyList_WhenCreated_ThenThrowsIAE() {
        try {
            ListBackedGenerator<String> emptyGenerator = new ListBackedGenerator<>(Collections.emptyList());
            fail("Creating a StringGenerator from an empty list should throw an IllegalArgumentException");
        } catch (IllegalArgumentException iae) {
            // expected behaviour
        }
    }

    @Test
    public void test_GivenSingleItemList_WhenCreated_ThenIsNotNull() {
        assertThat(singleItemGenerator, notNullValue());
    }

    @Test
    public void test_GivenSingleItemList_WhenRetrieved_ThenReturnsThatItem() {
        assertThat(singleItemGenerator.next(), is("Darth Vader"));
    }


    @Test
    public void test_GivenSingleItemList_WhenRetrievedTwice_ThenReturnsSameItem() {
        String firstRetrieval = singleItemGenerator.next();
        String secondRetrieval = singleItemGenerator.next();
        assertThat(firstRetrieval, sameInstance(secondRetrieval));
    }

    @Test
    public void testGivenTwoItemList_WhenRetrieved_ThenReturnsFirstItem() {
        assertThat(twoItemGenerator.next(), is("Han Solo"));
    }

    @Test
    public void testGivenTwoItemList_WhenRetrievedTwice_ThenReturnsSecondItem() {

        // throw away first item and advance generator
        twoItemGenerator.next();

        assertThat(twoItemGenerator.next(), is("Luke Skywalker"));
    }

    @Test
    public void testGivenTwoItemList_WhenRetrievedThrice_ThenWrapsAround() {

        String firstItem = twoItemGenerator.next();
        String secondItem = twoItemGenerator.next();
        String thirdItem = twoItemGenerator.next();

        assertThat(thirdItem, sameInstance(firstItem));
    }

    @Test
    public void testGivenStringGenerator_WhenAttemptingToChangeListAfterCreation_ThenOriginalListUsed() {

        List<String> originalList = new ArrayList<>(Arrays.asList("Item 1", "Item 2"));
        ListBackedGenerator<String> originalListGenerator = new ListBackedGenerator<>(originalList);

        // Remove second item from original list
        originalList.remove(1);

        originalListGenerator.next();
        String secondItem = originalListGenerator.next();

        assertThat(secondItem, is("Item 2"));

    }

}