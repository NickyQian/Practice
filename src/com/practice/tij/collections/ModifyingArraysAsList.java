package com.practice.tij.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class ModifyingArraysAsList {
	@Test
	public void testCollectionsShuffled() {
		Random rand = new Random(47);
		Integer[] ia = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));
		System.out.println("Before shuffling: " + list1);
		Collections.shuffle(list1, rand);
		System.out.println("After shuffling: " + list1);
		System.out.println("array: " + Arrays.toString(ia));
		List<Integer> list2 = Arrays.asList(ia);
		System.out.println("Before shuffling: " + list2);
		Collections.shuffle(list2, rand);
		System.out.println("After shuffling: " + list2);
		System.out.println("array: " + Arrays.toString(ia));
	}

	@Test
	public void testArraysAsList() {
		TestObject[] testObjects = new TestObject[] { new TestObject(1), new TestObject(2), new TestObject(3) };
		List<TestObject> testObjectList1 = new ArrayList<TestObject>(Arrays.asList(testObjects));
		System.out.println("testObjects1:" + Arrays.toString(testObjects));
		System.out.println("testObjectList: " + testObjectList1);
		
		List<TestObject> testObjectList2 = Arrays.asList(testObjects);
		testObjects[0].value = 99;
		System.out.println("testObjects:" + Arrays.toString(testObjects));
		System.out.println("testObjectList1: " + testObjectList1);
		System.out.println("testObjectList2: " + testObjectList2);
		
		Collections.shuffle(testObjectList1);
		System.out.println("After testObjectList1 shuffled...");
		System.out.println("testObjects:" + Arrays.toString(testObjects));
		System.out.println("testObjectList1: " + testObjectList1);
		System.out.println("testObjectList2: " + testObjectList2);
		
		Collections.shuffle(testObjectList2);
		System.out.println("After testObjectList2 shuffled..."); // orgin array is shuffled too.
		System.out.println("testObjects:" + Arrays.toString(testObjects));
		System.out.println("testObjectList1: " + testObjectList1);
		System.out.println("testObjectList2: " + testObjectList2);
		
	}
}

class TestObject {
	int value;

	public TestObject(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(value);
	}
}
