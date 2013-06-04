package com.martinrist.sandbox.lang.innerClasses.cycles;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CycleTest {

	@Test
	public void testUnicycleFactoryCreatesUnicycles() {
		Cycle cycle = Unicycle.factory.getCycle();
		assertThat(cycle, instanceOf(Unicycle.class));
	}

	@Test
	public void testBicycleFactoryCreatesBicycles() {
		Cycle cycle = Bicycle.factory.getCycle();
		assertThat(cycle, instanceOf(Bicycle.class));
	}

	@Test
	public void testTricycleFactoryCreatesTricycles() {
		Cycle cycle = Tricycle.factory.getCycle();
		assertThat(cycle, instanceOf(Tricycle.class));
	}

}
