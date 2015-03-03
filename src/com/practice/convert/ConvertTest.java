package com.practice.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConvertTest {
	private static Map<String, String> testMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		setUp();
		// convert set to list
		List<String> list = new ArrayList<>(testMap.keySet());
		// convert list to array
		String[] array = list.toArray(new String[list.size()]);
		// convert array to list
		List<String> list2 = new ArrayList<>(Arrays.asList(array));

		traverse(list, array, list2);
	}

	private static void traverse(List<String> list, String[] array, List<String> list2) {
		System.out.println("===== list =======");
		list.forEach((a) -> System.out.println(a));
		System.out.println("====== array ======");
		for (String str : array) {
			System.out.println(str);
		}
		System.out.println("======list2======");
		list2.forEach(a -> System.out.println(a));
	}

	private static void setUp() {
		testMap.put("a", "a");
		testMap.put("b", "b");
		testMap.put("c", "c");
		testMap.put("d", "d");
		testMap.put("e", "e");
	}
}
