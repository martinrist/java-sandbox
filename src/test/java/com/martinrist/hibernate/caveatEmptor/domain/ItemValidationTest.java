package com.martinrist.hibernate.caveatEmptor.domain;

import org.junit.Test;
import org.parboiled.common.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ItemValidationTest {

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    @Test
    public void testValidateItem_WithNullName() {

        Set<ConstraintViolation<Item>> violations = validator.validate(new Item());
        assertThat(violations, iterableWithSize(1));

        ConstraintViolation<Item> violation = violations.iterator().next();
        assertConstraint(violation, "name", NotNull.class);
    }

    @Test
    public void testValidateItem_WithNameTooShort() {

        Item i = new Item();
        i.setName("x");

        Set<ConstraintViolation<Item>> violations = validator.validate(i);
        assertThat(violations, iterableWithSize(1));

        ConstraintViolation<Item> violation = violations.iterator().next();
        assertConstraint(violation, "name", Size.class);
    }

    @Test
    public void testValidateItem_WithNameTooLong() {

        Item i = new Item();
        i.setName(StringUtils.repeat('x', 256));

        Set<ConstraintViolation<Item>> violations = validator.validate(i);
        assertThat(violations, iterableWithSize(1));

        ConstraintViolation<Item> violation = violations.iterator().next();
        assertConstraint(violation, "name", Size.class);
    }

    @Test
    public void testValidateItem_WithPastEndDate() {

        Item i = new Item();
        i.setName("Item name");
        i.setAuctionEnd(new Date());

        Set<ConstraintViolation<Item>> violations = validator.validate(i);
        assertThat(violations, iterableWithSize(1));

        ConstraintViolation<Item> violation = violations.iterator().next();
        assertConstraint(violation, "auctionEnd", Future.class);

    }

    @Test
    public void testValidateItem_ValidObject() {

        Item i = new Item();
        i.setName("Item name");

        LocalDateTime future = LocalDateTime.now().plusHours(1);
        Date futureDate = Date.from(future.toInstant(ZoneOffset.UTC));
        i.setAuctionEnd(futureDate);

        Set<ConstraintViolation<Item>> violations = validator.validate(i);
        assertThat(violations, emptyIterable());



    }

    @Test
    public void testValidateItem_TwoFailures() {

        Item i = new Item();
        i.setAuctionEnd(new Date());

        Set<ConstraintViolation<Item>> violations = validator.validate(i);
        assertThat(violations, iterableWithSize(2));

    }

    private void assertConstraint(ConstraintViolation<Item> violation, String field, Class<?> annotation) {
        assertThat(violation.getPropertyPath().iterator().next().getName(), is(field));
        assertThat(violation.getConstraintDescriptor().getAnnotation(), instanceOf(annotation));
    }
}
