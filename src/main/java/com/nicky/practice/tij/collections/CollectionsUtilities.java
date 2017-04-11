package com.nicky.practice.tij.collections;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class CollectionsUtilities {
	private List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

	private PrintStream out = System.out;

	private void print(Object object) {
		out.println(object);
	}

	@Test
	public void utilitiesTest() {
		print("'list' disjoint (Four)?: " + Collections.disjoint(list, Collections.singletonList("Four")));
		print("max: " + Collections.max(list));
		print("min: " + Collections.min(list));
		print("max comparator: " + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		print("min comparator: " + Collections.min(list, String.CASE_INSENSITIVE_ORDER));

		List<String> subList = Arrays.asList("Four five six".split(" "));
		print("indexOfSubList: " + Collections.indexOfSubList(list, subList));
		print("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, subList));
		Collections.replaceAll(list, "one", "Yo");
		Collections.reverse(list);
		print("replaceAll: " + list);
		Collections.rotate(list, 3);
		print("rotate: " + list);
		List<String> source = Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		print("copy: " + list);
		Collections.swap(list, 0, list.size() - 1);
		print("swap: " + list);
		Collections.shuffle(list, new Random(47));
		print("shuffle: " + list);
		Collections.fill(list, "pop");
		print("fill: " + list);
		print("frequency of 'pop': " + Collections.frequency(list, "pop"));
		List<String> dups = Collections.nCopies(3, "snap");
		print("nCopies: " + dups);
	}
}
