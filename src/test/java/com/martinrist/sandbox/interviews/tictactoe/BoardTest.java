package com.martinrist.sandbox.interviews.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
	public void testRetrieveAllSqauresMatchesBoardSize() throws Exception {
		List<Square> allSquares = board.getAllSquares();
		assertEquals(DEFAULT_BOARD_SIZE * DEFAULT_BOARD_SIZE, allSquares.size());
	}

	// All squares

	// Counterpart of row / col tests for diagonals

	// Is a board full?

}
