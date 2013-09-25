package com.martinrist.cleancode.videostore;

public class RegularMovie extends Movie {

	public RegularMovie(final String title) {
		super(title);
	}

	@Override
	protected double determineAmount(final int daysRented) {
		double amount = 2;
		if (daysRented > 2)
			amount += (daysRented - 2) * 1.5;
		return amount;
	}

	@Override
	protected int determineFrequentRenterPoints(final int daysRented) {
		return 1;
	}

}
