package com.nicky.practice.java8.collectons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * FYI:
 * http://blog.jooq.org/2014/06/13/java-8-friday-10-subtle-mistakes-when-using
 * -the-streams-api/
 *
 */
public class StreamTest {
	private List<String> list;

	@Before
	public void setUp() {
		list = Lists.newArrayList("1", "2", "3", "4");
	}

	@Test
	public void testLimit() {
		/* limit: short-circuiting operation */
		IntStream.iterate(0, i -> i + 1).limit(10).forEach(intvalue -> System.out.println(intvalue));
		IntStream.iterate(0, i -> i + 1).limit(10).boxed().forEach(intvalue -> System.out.println(intvalue.intValue())); // boxed: change int to Integer
	}

	@Test
	public void testInfinite() {
		IntStream.iterate(0, i -> (i + 1) % 2).limit(10).distinct().forEach(System.out::println);
		// IntStream.iterate(0, i -> (i + 1) %
		// 2).distinct().limit(10).forEach(System.out::println); // wrong.
		// infinite streams. It's bad.
	}

	@Test
	public void testSql() {
		StringBuilder sb = new StringBuilder();
		IntStream.iterate(0, i -> i + 1).limit(10) // LIMIT
				.skip(5) // OFFSET
				.forEach(item -> sb.append(item));
		assertEquals("56789", sb.toString());
	}

	@Test
	public void testListRemve() {
		list.stream().sorted().peek(str -> list.remove(str)).forEach(System.out::println);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testListadd() {
		list.stream().sorted().peek(str -> list.add(str)).count();
		assertEquals(8, list.size());
	}

	@Test
	public void testToArray() {
		Object[] strArray = Stream.of("a", "b", "c").toArray();
		for (Object str : strArray) {
			System.out.println(str);
		}
	}

	@Test
	public void testPeek() {
		long count = list.stream().peek(System.out::println).limit(2).count();
		assertEquals(2, count);
	}

	@Test
	public void testArrayStream() {
		String[] s = { "1", "2" };
		Arrays.stream(s).forEach(System.out::println);
	}
}
