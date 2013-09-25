package com.martinrist.cleancode.videostore;

public class ChildrensMovie extends Movie {

	public ChildrensMovie(final String title) {
		super(title);
	}

	@Override
	double determineAmount(final int daysRented) {
		double amount = 1.5;
		if (daysRented > 3)
			amount += (daysRented - 3) * 1.5;
		return amount;
	}

	@Override
	int determineFrequentRenterPoints(final int daysRented) {
		return 1;
	}
}
