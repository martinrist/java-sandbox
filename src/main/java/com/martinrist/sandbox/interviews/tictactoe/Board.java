package com.martinrist.sandbox.interviews.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private final int size;

	public Board(final int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Cannot create board of size " + size);
		}
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public List<Square> getRow(final int rowNum) {
		if (rowNum >= size || rowNum < 0) {
			throw new IllegalArgumentException("Cannot access row " + rowNum + " on a board of size " + size);
		}

		List<Square> row = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			row.add(new Square());
		}

		return row;
	}

	public List<Square> getColumn(final int columnNum) {
		if (columnNum >= size || columnNum < 0) {
			throw new IllegalArgumentException("Cannot access column " + columnNum + " on a board of size " + size);
		}

		List<Square> column = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			column.add(new Square());
		}

		return column;
	}

	public List<Square> getAllSquares() {
		List<Square> allSquares = new ArrayList<>(size * size);

		for (int i = 0; i < size * size; i++) {
			allSquares.add(new Square());
		}

		return allSquares;
	}

}
