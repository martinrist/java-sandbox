package com.martinrist.sandbox.lang.reflect;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.martinrist.sandbox.lang.ClassWithPrivateField;

public class FieldTest {

	public final static String PUBLIC_STATIC_FIELD = "STATIC FIELD";

	public final String publicField = "publicField";
	protected final String protectedField = "protectedField";
	final String defaultField = "defaultField";
	@SuppressWarnings("unused")
	private final String privateField = "privateField";

	@Test
	public void testGetFieldsOnlyAccessesPublicFields() {
		List<Field> fieldList = Arrays.asList(this.getClass().getFields());
		assertThat(fieldList, hasSize(2));
	}

	@Test
	public void testGetDeclaredFieldsAccessesAllFields() {
		List<Field> fieldList = Arrays.asList(this.getClass().getDeclaredFields());
		assertThat(fieldList, hasSize(5));
	}

	@Test
	public void testGetFieldCanAccessPublicFields() throws Exception {
		Field publicFieldObject = this.getClass().getField("publicField");
		assertThat(publicFieldObject.getName(), equalTo("publicField"));
	}

	@Test(expected = NoSuchFieldException.class)
	@SuppressWarnings("unused")
	public void testGetFieldCannotAccessProtectedField() throws Exception {
		Field protectedFieldObject = this.getClass().getField("protectedField");
	}

	@Test(expected = NoSuchFieldException.class)
	@SuppressWarnings("unused")
	public void testGetFieldCannotAccessDefaultField() throws Exception {
		Field protectedFieldObject = this.getClass().getField("defaultField");
	}

	@Test(expected = NoSuchFieldException.class)
	@SuppressWarnings("unused")
	public void testGetFieldCannotAccessPrivateField() throws Exception {
		Field protectedFieldObject = this.getClass().getField("privateField");
	}

	@Test
	public void testGetFieldCanAccessPublicStaticField() throws Exception {
		Field publicStaticFieldObject = this.getClass().getField("PUBLIC_STATIC_FIELD");
		assertNotNull(publicStaticFieldObject);
	}

	@Test
	public void testPublicStaticFieldObjectHasCorrectModifiers() throws Exception {
		Field publicStaticFieldObject = this.getClass().getDeclaredField("PUBLIC_STATIC_FIELD");
		int modifiers = publicStaticFieldObject.getModifiers();
		assertTrue(Modifier.isPublic(modifiers));
		assertTrue(Modifier.isFinal(modifiers));
		assertTrue(Modifier.isStatic(modifiers));
	}

	@Test(expected = IllegalAccessException.class)
	@SuppressWarnings("unused")
	public void testAccessingPrivateFieldThrowsException() throws Exception {
		ClassWithPrivateField obj = new ClassWithPrivateField("Martin");
		Field privateField = ClassWithPrivateField.class.getDeclaredField("name");
		String value = (String) privateField.get(obj);
	}

	@Test
	public void testUsingSetAccessibleAllowsModificationOfPrivateFields() throws Exception {
		ClassWithPrivateField obj = new ClassWithPrivateField("Martin");
		Field privateField = ClassWithPrivateField.class.getDeclaredField("name");
		privateField.setAccessible(true);
		privateField.set(obj, "Nicola");
		assertThat(obj.getName(), equalTo("Nicola"));
	}

	@Test(expected = SecurityException.class)
	public void testUsingSetAccessibleWithRejectingSecurityManager() throws Exception {
		System.setSecurityManager(new SecurityManager());
		Field privateField = ClassWithPrivateField.class.getDeclaredField("name");
		privateField.setAccessible(true);
	}
}