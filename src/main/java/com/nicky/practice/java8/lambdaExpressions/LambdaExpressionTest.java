package com.nicky.practice.java8.lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class LambdaExpressionTest {

	@Test
	public void withOutLambda() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		names.forEach((a) -> System.out.println(a));
	}

	@Test
	public void withLambda() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
		// Lambda的简写 （Java编译器可以自动推导出参数类型）
		Collections.sort(names, (a, b) -> a.compareTo(b));

		names.forEach((a) -> System.out.println(a));
	}
}
