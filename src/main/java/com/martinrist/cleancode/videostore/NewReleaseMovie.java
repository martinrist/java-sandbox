package com.martinrist.cleancode.videostore;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(final String title) {
		super(title);
	}

	@Override
	protected double determineAmount(final int daysRented) {
		return daysRented * 3;
	}

	@Override
	protected int determineFrequentRenterPoints(final int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
}
