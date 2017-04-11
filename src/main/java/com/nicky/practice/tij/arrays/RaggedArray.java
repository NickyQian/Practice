package com.nicky.practice.tij.arrays;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class RaggedArray {
	@Test
	public void testRaggedArray() {
		Random rand = new Random(47);
		// 3-D array with varied-length vectors:
		int[][][] a = new int[rand.nextInt(7)][][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[rand.nextInt(5)][];
			for (int j = 0; j < a[i].length; j++)
				a[i][j] = new int[rand.nextInt(5)];
		}
		System.out.println(Arrays.deepToString(a));
	}

	@Test
	public void testMultidimensionalObjectArrays() {
		String[][] spheres = {
				{ new String("00"), new String("01") },
				{ new String("10"), new String("11"), new String("12"), new String("13") },
				{ new String("20"), new String("21"), new String("22"), new String("23"),
						new String("30"), new String("31"), new String("32"), new String("33") }, };
		System.out.println(Arrays.deepToString(spheres));
		System.out.println(spheres.length);
		System.out.println(spheres[2].length);
		System.out.println(spheres[1].length);
	}
}