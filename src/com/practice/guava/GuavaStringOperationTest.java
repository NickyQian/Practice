package com.practice.guava;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class GuavaStringOperationTest {
	@Test
	public void testJoiner() {
		List<String> strList = Lists.newArrayList();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add(null);
		String joinResult = Joiner.on(',').skipNulls().join(strList);
		assertEquals("1,2,3,4", joinResult);
	}

	@Test
	public void testSpliter() {

		List<String> expectedList = Lists.newArrayList("1", "2", "3", "4", "5");
		String str = "1;;2;3;4;5;";
		List<String> splitterResult = Splitter.on(';').omitEmptyStrings().trimResults().splitToList(str);
		
		IntStream.range(0, expectedList.size()).forEach((idx) -> {
			assertEquals(expectedList.get(idx), splitterResult.get(idx));
		});

		List<String> result = Splitter.on(',').trimResults().splitToList("a, b  \t, c\n");
		Iterator<String> iterator = result.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			String result1 = iterator.next();
			char a = 'a';
			String expected = String.valueOf((char) (a + i));
			expected.trim();
			i++;
			assertEquals(expected, result1);
		}
	}
	
	@Test
	public void testWithKeyValueSeparator() {
		String str = "1:1;;2:2;3:3;4:4;5:5;";
		Map<String, String> splitterResult = Splitter.on(';').omitEmptyStrings().trimResults().withKeyValueSeparator(":").split(str);
		splitterResult.entrySet().stream().forEach((entry) -> {
			System.out.print(entry.getKey());
			System.out.print(":");
			System.out.print(entry.getValue());
			System.out.println(";");
		});
	}
}
