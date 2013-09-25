package com.martinrist.cleancode.videostore;

public class Rental {

	private final Movie movie;
	private final int daysRented;

	public Rental(final Movie movie, final int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public String getTitle() {
		return movie.getTitle();
	}

	double determineAmount() {
		return movie.determineAmount(daysRented);
	}

	int determineFrequentRenterPoints() {
		return movie.determineFrequentRenterPoints(daysRented);
	}
}