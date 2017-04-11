package com.nicky.practice.tij.string;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class StringBuilderTest {
	private Random rand = new Random(47);

	@Test
	public void test() {
		StringBuilder result = new StringBuilder();
		result.append("[");
		IntStream.range(0, 25).forEach(i -> {
			result.append(rand.nextInt(100));
			result.append(", ");
		});
		result.delete(result.length() - 2, result.length());
		result.append("]");
		System.out.println(result);
	}
}
