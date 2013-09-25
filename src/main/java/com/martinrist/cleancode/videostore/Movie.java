package com.martinrist.cleancode.videostore;

public abstract class Movie {

	private final String title;

	public Movie(final String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	abstract double determineAmount(final int daysRented);

	abstract int determineFrequentRenterPoints(final int daysRented);

}