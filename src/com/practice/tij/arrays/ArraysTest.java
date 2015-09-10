package com.practice.tij.arrays;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ArraysTest {
	@Test
	public void fillingArrays() {
		int size = 10;
		boolean[] booleanVaules = new boolean[size];
		byte[] byteValues = new byte[size];
		short[] shortValues = new short[size];
		char[] charValues = new char[size];
		Arrays.fill(booleanVaules, true);
		Arrays.fill(byteValues, (byte) 11);
		Arrays.fill(shortValues, (short) 1);

		System.out.println(Arrays.toString(booleanVaules));
		System.out.println(Arrays.toString(byteValues));
		System.out.println(Arrays.toString(shortValues));
		System.out.println(Arrays.toString(charValues));
		System.out.println("Default char value: " + (int) charValues[0]);
	}

	class TestObject {
		public int value = 1;

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@Test
	public void testSystemArraycopy() {
		TestObject[] src = new TestObject[10];
		// fill the array with one some objet.
		Arrays.fill(src, new TestObject());
		TestObject[] dest = new TestObject[10];
		// This method only copy the reference for the objects
		System.arraycopy(src, 0, dest, 0, src.length);
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
		src[0].value = 2;
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
	}

	@Test
	public void testArraysSort() {
		String[] a = { "1", "3", "2" };
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		Arrays.sort(a, Collections.reverseOrder());
		System.out.println(Arrays.toString(a));
		Arrays.binarySearch(a, "3");
	}
}
