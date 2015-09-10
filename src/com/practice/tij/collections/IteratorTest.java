package com.practice.tij.collections;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class IteratorTest {

	@Test
	public void testListIterator() {
		List<String> strList = Arrays.asList("1", "2", "3", "4");
		ListIterator<String> listIterator = strList.listIterator();

		System.out.println(String.format("index: %s, value: %s", listIterator.nextIndex(),
				strList.get(listIterator.nextIndex())));
		System.out.println("Start traversing...");
		while (listIterator.hasNext()) {
			System.out.println(String.format("index: %s, value: %s", listIterator.nextIndex(), listIterator.next()));
		}

		System.out.println(String.format("index: %s, value: %s", listIterator.previousIndex(),
				strList.get(listIterator.previousIndex())));
		System.out.println("Start reverse traversing...");
		while (listIterator.hasPrevious()) {
			System.out.println(String.format("index: %s, value: %s", listIterator.previousIndex(),
					listIterator.previous()));
		}
	}
}
