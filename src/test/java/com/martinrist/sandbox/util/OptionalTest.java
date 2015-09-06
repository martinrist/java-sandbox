package com.martinrist.sandbox.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class OptionalTest {

    private Function<Integer, Integer> inc = (s -> s + 1);
    private Function<String, String> id = (s -> s);
    private List<String> names = Arrays.asList("Alice", "Bob", "Christine");;

    @Test
    public void testMapOverSome() {
        assertEquals(Optional.of(2), Optional.of(1).map(inc));
    }

    @Test
    public void testMapOverNone() {
        Optional<Integer> empty = Optional.ofNullable(null);
        assertFalse(empty.map(inc).isPresent());
    }

    @Test
    public void testListObeysFunctorIdentityLaw() {
        List<String> listThenMapId = names.stream().map(id).collect(Collectors.toList());
        List<String> idThenList = Arrays.asList(id.apply("Alice"), id.apply("Bob"), id.apply("Christine"));
        assertEquals(listThenMapId, idThenList);
    }

    @Test
    public void testOptionalObeysFunctorIdentityLaw() {
        Optional<String> optionalThenMapId = Optional.of("Zombie").map(id);
        Optional<String> idThenOptional = Optional.of(id.apply("Zombie"));
        assertEquals(optionalThenMapId, idThenOptional);
    }

    @Test
    public void testListObeysFunctorCompositionLaw() {

        Function<String, Integer> len = String::length;
        Function<Integer, Integer> sqr = (i -> i * i);

        Function<String, Integer> lenSqr = sqr.compose(len);

        List<Integer> applyIndividualFunctions = names.stream().map(len).map(sqr).collect(Collectors.toList());
        List<Integer> applyComposedFunction = names.stream().map(lenSqr).collect(Collectors.toList());

        assertEquals(applyIndividualFunctions, applyComposedFunction);

    }

    @Test
    public void testOptionalObeysFunctorCompositionLaw() {

        Function<String, Integer> len = String::length;
        Function<Integer, Integer> sqr = (i -> i * i);

        Function<String, Integer> lenSqr = sqr.compose(len);

        Optional<Integer> applyIndividualFunctions = Optional.of("Hello").map(len).map(sqr);
        Optional<Integer> applyComposedFunction = Optional.of("Hello").map(lenSqr);

        assertEquals(applyIndividualFunctions, applyComposedFunction);

    }

}
