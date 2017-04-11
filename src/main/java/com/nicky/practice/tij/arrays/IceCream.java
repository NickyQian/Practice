package com.nicky.practice.tij.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class IceCream {
	private static Random rand = new Random(47);
	static final String[] FLAVORS = { "Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip",
			"Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie" };

	public static String[] flavorSet(int n) {
		if (n > FLAVORS.length) {
			throw new IllegalArgumentException("Set too big");
		}
		String[] results = new String[n];
		boolean[] picked = new boolean[FLAVORS.length];
		IntStream.range(0, n).forEach(i -> {
			int t;
			do
				t = rand.nextInt(FLAVORS.length);
			while (picked[t]);
			results[i] = FLAVORS[t];
			picked[t] = true;
		});
		return results;
	}

	@Test
	public void test() {
		IntStream.range(0, 7).forEach(i -> {
			System.out.println(Arrays.toString(flavorSet(3)));
		});
	}
}
