package com.practice.java8.collectons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * FYI:
 * http://blog.jooq.org/2014/06/13/java-8-friday-10-subtle-mistakes-when-using
 * -the-streams-api/
 *
 */
public class StreamTest {
	@Test
	public void testLimit() {
		/* limit: short-circuiting operation */
		IntStream.iterate(0, i -> i + 1).limit(10).forEach(System.out::println);
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
		List<String> list = Lists.newArrayList("1", "2", "3", "4");
		list.stream().sorted().peek(str -> list.remove(str)).forEach(System.out::println);
		assertTrue(list.isEmpty());
	}

	@Test
	public void testListadd() {
		List<String> list = Lists.newArrayList("1", "2", "3", "4");
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

}
