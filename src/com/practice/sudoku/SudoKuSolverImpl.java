package com.practice.sudoku;

import static org.junit.Assert.assertArrayEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class SudoKuSolverImpl implements SudokuSolver {

	private SudokuSolverStrategy solver = new SudokuSolverBacktracking();

	@Override
	public byte[] solve(byte[] sudoku) {
		int[][] sudokuArray = convertSudokuByteToArray(sudoku);
		solver.solveSudoku(sudokuArray);
		return convertSudokuArrayToByte(sudokuArray);
	}

	private int[][] convertSudokuByteToArray(byte[] sudokuByte) {
		int[][] result = new int[9][9];
		IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> {
			char valueStr = (char) (sudokuByte[row * 9 + column]);
			if (valueStr == '.') {
				result[row][column] = 0;
			} else {
				result[row][column] = Integer.valueOf(String.valueOf(valueStr));
			}
		}));
		return result;
	}

	private byte[] convertSudokuArrayToByte(int[][] sudokuArray) {
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, 9).forEach(row -> IntStream.range(0, 9).forEach(column -> {
			sb.append(sudokuArray[row][column]);
		}));
		return sb.toString().getBytes();
	}

	@Test
	public void test() {
		byte[] s = ".7.6.2.8...48.71......1....7.8...6.4.2.....9.4.6...3.2....8......23.19...6.5.4.2.".getBytes();
		convertSudokuByteToArray(s);
	}

	@Test
	public void sodoku01() {
		assertArrayEquals(
				"438561792219347658567892134651234879972618543384975261725483916893156427146729385".getBytes(),
				new SudoKuSolverImpl()
						.solve(".38...79.2...4.6.856...2..4..1.3.....7.6.8.4.....7.2..7..4...168.3.5...7.46...38."
								.getBytes()));
	}

}
