package com.practice.java7.lang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GrammarChange {
	private int a = 0B110101010101; // 0B开头表示二进制
	private int b = 100_000; // _ 可以作为分隔符

	@Test
	public void testStringSwitch() {
		String switchStr = "ABC1"; // Switch可以用String
		switch (switchStr) {
		case "abc":
			System.out.println(switchStr);
			break;
		case "ABC":
			System.out.println(switchStr);
			break;
		default:
			System.out.println("Error String.");
		}
		List<Integer> test = new ArrayList<>(); // 省略泛型类型 <>不能省
		test.add(a);
		test.add(b);
	}

}
