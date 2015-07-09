package com.practice.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ConvertTest {
	private static Map<String, String> testMap = new LinkedHashMap<>();

	@Test(expected = ClassCastException.class)
	public void testConvertStringArrayException() {
		Object[] s = { "a", "b", "c" };
		String[] strs = (String[]) s;
		for (String str : strs) {
			System.out.println(str);
		}
	}

	@Test(expected = ClassCastException.class)
	public void testConvertArrayExcetpiton() {
		Object[] s = { 1, 2, 3 };
		Integer[] strs = (Integer[]) s;
		for (Integer str : strs) {
			System.out.println(str);
		}
	}

	@Test
	public void testConvertArray() {
		Object[] s = { 1, 2, 3 };
		Integer[] stringArray = Arrays.copyOf(s, s.length, Integer[].class);
		for (Integer str : stringArray) {
			System.out.println(str);
		}
	}

	@Test
	public void testConvertClass() {
		Object[] s = new ConvertTest[2];
		s[0] = new ConvertTest();
		s[1] = new ConvertTest();
		ConvertTest[] stringArray = (ConvertTest[]) s;
		for (ConvertTest str : stringArray) {
			System.out.println(str);
		}
	}

	@Test
	public void testListArrayConvert() {
		setUp();
		// convert set to list
		List<String> list = new ArrayList<>(testMap.keySet());
		// convert list to array
		String[] array = list.toArray(new String[list.size()]);
		// convert array to list
		List<String> list2 = new ArrayList<>(Arrays.asList(array));

		traverse(list, array, list2);
	}

	private void traverse(List<String> list, String[] array, List<String> list2) {
		System.out.println("===== list =======");
		list.forEach((a) -> System.out.println(a));
		System.out.println("====== array ======");
		for (String str : array) {
			System.out.println(str);
		}
		System.out.println("======list2======");
		list2.forEach(a -> System.out.println(a));
	}

	private void setUp() {
		testMap.put("a", "a");
		testMap.put("b", "b");
		testMap.put("c", "c");
		testMap.put("d", "d");
		testMap.put("e", "e");
	}
}
