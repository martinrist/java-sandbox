package com.martinrist.sandbox.interviews.tictactoe;

import static com.martinrist.sandbox.interviews.tictactoe.Counter.O;
import static com.martinrist.sandbox.interviews.tictactoe.Counter.X;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private static final int DEFAULT_BOARD_SIZE = 3;
	Board board;

	@Before
	public void setUp() throws Exception {
		board = new Board(DEFAULT_BOARD_SIZE);
	}

	@Test
	public void testCreateBoardOfZeroSizeThrowsException() throws Exception {
		try {
			board = new Board(0);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testCreateBoardOfNegativeSizeThrowsException() throws Exception {
		try {
			board = new Board(-3);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testCanCreateBoardWithSize() throws Exception {
		assertEquals(DEFAULT_BOARD_SIZE, board.getSize());
	}

	@Test
	public void testRetrievalOfRowsIn3x3Board() throws Exception {
		assertNotNull(board.getRow(0));
		assertNotNull(board.getRow(1));
		assertNotNull(board.getRow(2));
	}

	@Test
	public void testRetrievalOfRowOutsideBoardThrowsIllegalArgumentException() throws Exception {
		try {
			board.getRow(DEFAULT_BOARD_SIZE);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrievalOfNegativeRowThrowsIllegalArgumentException() throws Exception {
		try {
			board.getRow(-1);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrievedRowSizeMatchesBoardSize() throws Exception {
		List<Square> row0 = board.getRow(0);
		assertEquals(DEFAULT_BOARD_SIZE, row0.size());

		List<Square> row1 = board.getRow(1);
		assertEquals(DEFAULT_BOARD_SIZE, row1.size());

		List<Square> row2 = board.getRow(2);
		assertEquals(DEFAULT_BOARD_SIZE, row2.size());
	}

	@Test
	public void testRetrievalOfColumnsIn3x3Board() throws Exception {
		assertNotNull(board.getColumn(0));
		assertNotNull(board.getColumn(1));
		assertNotNull(board.getColumn(2));
	}

	@Test
	public void testRetrievalOfColumnOutsideBoardThrowsIllegalArgumentException() throws Exception {
		try {
			board.getColumn(DEFAULT_BOARD_SIZE);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrievalOfNegativeColumnThrowsIllegalArgumentException() throws Exception {
		try {
			board.getColumn(-1);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrievedColumnSizeMatchesBoardSize() throws Exception {
		List<Square> column0 = board.getColumn(0);
		assertEquals(DEFAULT_BOARD_SIZE, column0.size());

		List<Square> column1 = board.getColumn(1);
		assertEquals(DEFAULT_BOARD_SIZE, column1.size());

		List<Square> column2 = board.getColumn(2);
		assertEquals(DEFAULT_BOARD_SIZE, column2.size());
	}

	@Test
	public void testRetrieveSquareWithValidReference() throws Exception {
		Square square;
		for (int row = 0; row < DEFAULT_BOARD_SIZE; row++) {
			for (int col = 0; col < DEFAULT_BOARD_SIZE; col++) {
				square = board.getSquare(row, col);
				assertNotNull(square);
				assertFalse(square.isFilled());
			}
		}
	}

	@Test
	public void testRetrieveSquareWithNegativeRowReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			@SuppressWarnings("unused")
			Square square = board.getSquare(-1, 0);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrieveSquareWithOutOfBoundsRowReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			@SuppressWarnings("unused")
			Square square = board.getSquare(DEFAULT_BOARD_SIZE, 0);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrieveSquareWithNegativeColumnReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			@SuppressWarnings("unused")
			Square square = board.getSquare(0, -1);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testRetrieveSquareWithOutOfBoundsColumnReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			@SuppressWarnings("unused")
			Square square = board.getSquare(0, DEFAULT_BOARD_SIZE);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testPlaceCounterWithNegativeRowReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			board.placeCounter(X, -1, 0);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testPlaceCounterWithOutOfBoundsRowReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			board.placeCounter(X, DEFAULT_BOARD_SIZE, 0);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testPlaceCounterWithNegativeColumnReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			board.placeCounter(X, 0, -1);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testPlaceCounterWithOutOfBoundsColumnReferenceThrowsIllegalArgumentException() throws Exception {
		try {
			board.placeCounter(X, 0, DEFAULT_BOARD_SIZE);
			fail("Expected IllegalArgumentException not thrown");
		} catch (IllegalArgumentException iae) {
			// Expected behaviour
		}
	}

	@Test
	public void testAfterPlacingCounterSquareIsFilled() throws Exception {
		for (int row = 0; row < DEFAULT_BOARD_SIZE; row++) {
			for (int col = 0; col < DEFAULT_BOARD_SIZE; col++) {
				board.placeCounter(X, row, col);
				assertTrue(board.getSquare(row, col).isFilled());
			}
		}
	}

	@Test
	public void testAfterPlacingCounterSquareIsFilledWithSameCounter() throws Exception {
		for (int row = 0; row < DEFAULT_BOARD_SIZE; row++) {
			for (int col = 0; col < DEFAULT_BOARD_SIZE; col++) {
				board.placeCounter(X, row, col);
				assertEquals(X, board.getSquare(row, col).getCounter());
			}
		}
	}

	@Test
	public void testRetrieveRowsFromSampleBoard() throws Exception {
		constructSampleBoard();

		List<Square> row0 = board.getRow(0);
		assertEquals(X, row0.get(0).getCounter());
		assertFalse(row0.get(1).isFilled());
		assertFalse(row0.get(2).isFilled());

		List<Square> row1 = board.getRow(1);
		assertEquals(X, row1.get(0).getCounter());
		assertEquals(O, row1.get(1).getCounter());
		assertFalse(row1.get(2).isFilled());

		List<Square> row2 = board.getRow(2);
		assertEquals(X, row2.get(0).getCounter());
		assertEquals(O, row2.get(1).getCounter());
		assertEquals(X, row2.get(2).getCounter());
	}

	// Test after constructing board with:
	// X
	// XO
	// XOX
	// Should be able to retrieve rows correctly

	@Test
	public void testRetrieveColumnsFromSampleBoard() throws Exception {
		constructSampleBoard();

		List<Square> col0 = board.getColumn(0);
		assertEquals(X, col0.get(0).getCounter());
		assertEquals(X, col0.get(1).getCounter());
		assertEquals(X, col0.get(2).getCounter());

		List<Square> col1 = board.getColumn(1);
		assertFalse(col1.get(0).isFilled());
		assertEquals(O, col1.get(1).getCounter());
		assertEquals(O, col1.get(2).getCounter());

		List<Square> col2 = board.getColumn(2);
		assertFalse(col2.get(0).isFilled());
		assertFalse(col2.get(1).isFilled());
		assertEquals(X, col2.get(2).getCounter());
	}

	private void constructSampleBoard() {
		board.placeCounter(X, 0, 0);
		board.placeCounter(X, 1, 0);
		board.placeCounter(O, 1, 1);
		board.placeCounter(X, 2, 0);
		board.placeCounter(O, 2, 1);
		board.placeCounter(X, 2, 2);
	}

	// Counterpart of row / col tests for diagonals

	// Is a board full?

	// Game status - WIN, DRAW, NOT COMPLETE
}
