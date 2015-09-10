package com.practice.tij.collections;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

public class EnvironmentVariables {
	@Test
	public void test() {
		for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

	@Test
	public void testForeach() {
		ArrayIsNotIterable.test(Arrays.asList(1, 2, 3));
		String[] strings = { "A", "B", "C" };
		// An array works in foreach, but it’s not Iterable:
		// ArrayIsNotIterable.test(strings); //compile error.
		for (String s : strings) {
			System.out.print(s + " ");
		}
		System.out.println();
		// You must explicitly convert it to an Iterable:
		ArrayIsNotIterable.test(Arrays.asList(strings));
	}
}

class ArrayIsNotIterable {
	static <T> void test(Iterable<T> ib) {
		for (T t : ib)
			System.out.print(t + " ");
		System.out.println();
	}
}