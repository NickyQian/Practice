package com.practice.sudoku;

public class SudokuSolverBacktracking implements SudokuSolverStrategy {

	// private PrintStream out = System.out;

	@Override
	public boolean solveSudoku(int[][] sudokuArray) {
		int[] position = new int[2];

		if (!findZeroLocation(sudokuArray, position)) {
			return true;
		}
		int row = position[0];
		int col = position[1];
		for (int tryValue = 1; tryValue <= 9; tryValue++) {
			if (isSafe(sudokuArray, row, col, tryValue)) {
				sudokuArray[row][col] = tryValue;
				if (solveSudoku(sudokuArray))
					return true;

				sudokuArray[row][col] = 0;
			}
		}
		return false;
	}

	boolean findZeroLocation(int[][] grid, int[] position) {
		for (int row = 0; row < 9; row++)
			for (int col = 0; col < 9; col++)
				if (grid[row][col] == 0) {
					position[0] = row;
					position[1] = col;
					return true;
				}
		return false;
	}

	private boolean isSafe(int[][] sudokuArray, int rowIdx, int colIdx, int tryValue) {
		return !existedInRow(sudokuArray[rowIdx], tryValue) && !existedInCol(sudokuArray, colIdx, tryValue)
				&& !existedInZone(sudokuArray, rowIdx - rowIdx % 3, colIdx - colIdx % 3, tryValue);
	}

	private boolean existedInZone(int[][] sudokuArray, int startZoneIndex, int startZoneColumn, int tryValue) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudokuArray[startZoneIndex + i][startZoneColumn + j] == tryValue)
					return true;
			}
		}
		return false;
	}

	private boolean existedInCol(int[][] sudokuArray, int colIdx, int tryValue) {
		for (int i = 0; i < 9; i++) {
			if (sudokuArray[i][colIdx] == tryValue) {
				return true;
			}
		}
		return false;
	}

	private boolean existedInRow(int[] sudokuArray, int tryValue) {
		for (int i = 0; i < 9; i++) {
			if (sudokuArray[i] == tryValue) {
				return true;
			}
		}
		return false;
	}
}
