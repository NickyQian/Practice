package com.practice.sudoku;

import java.util.stream.IntStream;

import org.junit.Test;

public class SudoKuSolverImpl implements SudokuSolver {

	@Override
	public byte[] solve(byte[] sudoku) {
		// TODO Auto-generated method stub
		return null;
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

	@Test
	public void test() {
		byte[] s = ".7.6.2.8...48.71......1....7.8...6.4.2.....9.4.6...3.2....8......23.19...6.5.4.2.".getBytes();
		convertSudokuByteToArray(s);
	}
}
