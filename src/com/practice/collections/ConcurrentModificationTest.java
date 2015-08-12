package com.practice.collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * Good blog to reference.
 * http://tech.puredanger.com/2009/02/02/java-concurrency-bugs-concurrentmodificationexception/
 *
 */
public class ConcurrentModificationTest {

	private List<String> testList;

	@Before
	public void before() {
		testList = Lists.newArrayList("1", "2", "3", "4", "5", "6");
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testConcurrentModification() {
		Iterator<String> it = testList.iterator();
		synchronized (testList) {
			while (it.hasNext()) {
				String value = it.next();
				testList.remove(value); // throw exception even if using
										// synchronized
			}
		}
	}

	@Test
	public void testCME1() {
		Iterator<String> it = testList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			if (value.equals("1")) {
				it.remove();
				// testList.add("2"); // this will throw CM exception.
			}
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testCME2() {
		Iterator<String> it = testList.iterator();
		testList.remove(2);
		/* After creation of an iterator, remove the first object of the list. */
		while (it.hasNext()) {
			it.next(); // will throw CME.
		}
	}

	@Test(expected = ConcurrentModificationException.class)
	public void testCME3() {
		Iterator<String> ite1 = testList.iterator();
		Iterator<String> ite2 = testList.iterator();

		ite1.next();
		ite1.remove();

		ite2.next();
		ite2.remove();

	}

	@Test
	public void testCopyOnWriteArray() {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>(testList);
		list.stream().forEach((e) -> {
			testList.remove(e);
		});
	}

}
