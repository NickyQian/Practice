package com.practice.guava;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;

public class GuavaCollectionTest {

	@Test
	public void testLists() {
		List<String> results = Lists.newArrayList("1", "2", "3");
		results.add("4");
		IntStream.range(0, results.size()).forEach((idx) -> {
			assertEquals(String.valueOf(idx + 1), results.get(idx));
		});
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testImmutable() {
		Map<String, String> map = ImmutableMap.of("ON", "TRUE", "OFF", "FALSE");
		map.put("test", "test1");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testImmutableBuildPattern() {
		Set<String> immutableSet = ImmutableSet.<String> builder().add("1").add("2").build();
		immutableSet.add("3");
	}

	@Test
	public void testMultset() { // can have duplicates value in one set
		Multiset<Integer> multiSet = HashMultiset.create();
		multiSet.add(10);
		multiSet.add(30);
		multiSet.add(30);
		multiSet.add(40);

		assertEquals(2, multiSet.count(30));
		assertEquals(4, multiSet.size());
	}
}
