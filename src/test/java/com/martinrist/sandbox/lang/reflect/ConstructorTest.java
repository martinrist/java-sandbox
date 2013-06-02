package com.martinrist.sandbox.lang.reflect;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.martinrist.sandbox.lang.ClassWithDefaultConstructor;
import com.martinrist.sandbox.lang.ClassWithPrivateNoArgConstructor;

public class ConstructorTest {

	@Test
	public void testGetConstructorsReturnsDefaultNoArgConstructor() {
		List<Constructor<?>> constructorList = Arrays.asList(ClassWithDefaultConstructor.class.getConstructors());
		assertThat(constructorList, hasSize(1));
	}

	@Test
	public void testGetConstructorsDoesntReturnDefaultConstructorWhenMadePrivate() {
		List<Constructor<?>> constructorList = Arrays.asList(ClassWithPrivateNoArgConstructor.class.getConstructors());
		assertThat(constructorList, hasSize(0));
	}

}
