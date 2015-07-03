package com.practice.designpattern.singleton;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

public class SingletonEnumTest {
	@Test
	public void testEmumSingleton1() {
		assertEquals("Detail", SingletonEnum.INSTANCE.getDetail());
	}

	@Test
	public void testEmumSingleton2() {
		List<String> results = SingletonEnum.INSTANCE.getDetailList();
		IntStream.rangeClosed(1, results.size()).forEach((idx) -> {
			assertEquals("Detail" + idx, results.get(idx - 1));
		});
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testEmumSingleton3() {
		List<String> results = SingletonEnum.INSTANCE.getDetailList();
		results.add("2");
	}
}