package com.martinrist.sandbox.interviews.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	private final Square[][] squares;

	public Board(final int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Cannot create board of size " + size);
		}

		squares = new Square[size][size];

		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				squares[row][col] = new Square();
			}
		}
	}

	public int getSize() {
		return squares.length;
	}

	public List<Square> getRow(final int rowNum) {
		int size = getSize();

		if (rowNum >= getSize() || rowNum < 0) {
			throw new IllegalArgumentException("Cannot access row " + rowNum + " on a board of size " + size);
		}

		return Arrays.asList(squares[rowNum]);
	}

	public List<Square> getColumn(final int columnNum) {
		int size = getSize();
		if (columnNum >= size || columnNum < 0) {
			throw new IllegalArgumentException("Cannot access column " + columnNum + " on a board of size " + size);
		}

		List<Square> column = new ArrayList<>(size);
		for (int rowNum = 0; rowNum < size; rowNum++) {
			column.add(squares[rowNum][columnNum]);
		}

		return column;
	}

	public void placeCounter(final Counter counter, final int row, final int col) {
		validatePositionArguments(row, col);
		squares[row][col].setCounter(counter);
	}

	public Square getSquare(final int row, final int col) {
		validatePositionArguments(row, col);
		return squares[row][col];
	}

	private void validatePositionArguments(final int row, final int col) {
		int size = getSize();
		if (row < 0 || row >= size || col < 0 || col >= size) {
			throw new IllegalArgumentException(String.format("Invalid square reference (row=%d, col=%d)", row, col));
		}
	}

	@Override
	public String toString() {

		int size = getSize();
		StringBuilder result = new StringBuilder();

		for (int row = 0; row < size; row++) {

			if (row != 0) {
				for (int i = 0; i < 2 * size - 1; i++) {
					result.append("-");
				}
				result.append("\n");
			}

			for (int col = 0; col < size; col++) {
				if (col != 0) {
					result.append('|');
				}

				result.append(getSymbolAt(row, col));
			}

			result.append("\n");
		}

		return result.toString();
	}

	private String getSymbolAt(final int row, final int col) {
		Square square = squares[row][col];
		return (square.isFilled() ? square.getCounter().toString() : " ");
	}
}
