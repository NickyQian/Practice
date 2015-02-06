package com.practice.java8.collectons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.practice.java8.fucntionalInterface.Person;

public class LambdaCollection {
	private static final int ARRAY_SIZE = 1000;
	private char CHAR_A = 'A';
	List<String> names = new ArrayList<>();

	@Before
	public void constructCollection() {
		Random ran = new Random();
		for (int i = 0; i < ARRAY_SIZE; i++) {
			int firstCharactor = ran.nextInt(26);
			int secondCharactor = ran.nextInt(26);
			String first = String.valueOf((char) (CHAR_A + firstCharactor));
			String second = String.valueOf((char) (CHAR_A + secondCharactor));
			names.add(first + second);
		}
		// names.forEach((s) -> System.out.println(s));
	}

	@Test
	public void testCollectionFilter() {
		// 需要注意的是，排序只创建了一个排列好后的Stream，
		// 而不会影响原有的数据源，排序之后原数据names是不会被修改的
		names.stream().filter((a) -> a.endsWith("A")).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
	}

	@Test
	public void testCollectionMap() {
		// 中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，
		// 你也可以通过map来讲对象转换成其他类型，
		// map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
		final List<Person> persons = new ArrayList<Person>();
		names.stream().filter((a) -> a.startsWith("N")).map((a) -> {
			return new Person(1, a);
		}).forEach(persons::add);

		List<Person> persons2 = names.stream().filter((a) -> a.startsWith("N")).map((a) -> {
			return new Person(1, a);
		}).collect(Collectors.toList());

		for (int i = 0; i < persons.size(); i++) {
			Assert.assertEquals(persons.get(i).getName(), persons2.get(i).getName());
		}
		persons.forEach((a) -> System.out.println(a.getName()));
		// Match 匹配
		// Stream提供了多种匹配操作，允许检测指定的Predicate是否匹配t整个Stream。所有的匹配操作都是最终操作，并返回一个boolean类型的值。
		persons.add(new Person(2, "Wrong Person"));
		Assert.assertEquals(true, persons.stream().anyMatch((a) -> a.getName().startsWith("N")));
		Assert.assertEquals(false, persons.stream().allMatch((a) -> a.getName().startsWith("N")));
		Assert.assertEquals(true, persons.stream().noneMatch((a) -> a.getName().startsWith("A")));
	}
}
