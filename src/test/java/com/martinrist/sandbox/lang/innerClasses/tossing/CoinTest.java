package com.martinrist.sandbox.lang.innerClasses.tossing;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CoinTest {

	@Test
	public void testCoinFactoryCreatesCoin() {
		Tossable t = Coin.factory.create();
		assertThat(t, instanceOf(Coin.class));
	}

	@Test
	public void testTossedCoinReturnsDescriptionHeadsOrTails() {
		Tossable t = Coin.factory.create();
		Result result = t.toss();
		assertThat(result.getDescription(), isOneOf("Heads", "Tails"));
	}

	@Test
	public void testTossedCoinReturnsValue0Or1() {
		Tossable t = Coin.factory.create();
		Result result = t.toss();
		assertThat(result.getValue(), isOneOf(0, 1));
	}

}
