package com.martinrist.cleancode.videostore;

import java.util.ArrayList;
import java.util.List;

public class Statement {

	private final String customerName;
	private final List<Rental> rentals = new ArrayList<Rental>();
	private double totalAmount;
	private int frequentRenterPoints;

	public Statement(final String customerName) {
		this.customerName = customerName;
	}

	public void addRental(final Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return customerName;
	}

	public String generate() {
		clearTotals();
		String statementText = header();
		statementText += rentalLines();
		statementText += footer();
		return statementText;
	}

	private void clearTotals() {
		totalAmount = 0;
		frequentRenterPoints = 0;
	}

	private String header() {
		return "Rental Record for " + customerName + "\n";
	}

	private String rentalLines() {
		String rentalLines = "";
		for (Rental rental : rentals)
			rentalLines += rentalLine(rental);
		return rentalLines;
	}

	private String rentalLine(final Rental rental) {
		double rentalAmount = rental.determineAmount();
		frequentRenterPoints += rental.determineFrequentRenterPoints();
		totalAmount += rentalAmount;

		return formatRentalLine(rental, rentalAmount);
	}

	private String formatRentalLine(final Rental rental, final double rentalAmount) {
		return String.format("\t%s\t%.1f\n", rental.getTitle(), rentalAmount);
	}

	private String footer() {
		return String
				.format("You owed %.1f\nYou earned %d frequent renter points\n", totalAmount, frequentRenterPoints);
	}

	public double getTotal() {
		return totalAmount;
	}

	public int getFrequentRenterPoints() {
		return frequentRenterPoints;
	}
}