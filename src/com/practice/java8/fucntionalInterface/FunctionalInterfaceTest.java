package com.practice.java8.fucntionalInterface;

import org.junit.Assert;
import org.junit.Test;

public class FunctionalInterfaceTest {

	@Test
	public void convertTest() {
		Converter<String, Integer> converter = (input) -> Integer.valueOf(input);
		Converter<String, String> converterAnother = (a) -> a + "1";
		Integer converted = converter.convert("123");
		Integer expectedResult = new Integer(123);
		Assert.assertEquals(expectedResult, converted);
		Assert.assertEquals("test1", converterAnother.convert("test"));
		// Test default method in interface
		Assert.assertEquals("a", converterAnother.defaulConvert("a"));
	}

	@Test
	public void staticMethodTest() {
		Converter<String, Integer> converter = Integer::valueOf;
		Assert.assertEquals(new Integer(12), converter.convert("12"));
	}

	@Test
	public void instanceMethodTest() {
		Person personTest = new Person(1, "Nick");
		Converter<Integer, String> instanceMethodConverter = personTest::getNameById;
		Assert.assertEquals("Nick", instanceMethodConverter.convert(1));
		// this converter is relative to the status of person instances.
		personTest.setId(2);
		Assert.assertEquals("Wrong Id.", instanceMethodConverter.convert(1));
	}

	@Test
	public void constructMethodTest() {
		// 构造函数返回自己的实例，应用到personfactory的函数接口上
		PersonFactory<Person> personFactory = Person::new;
		Person nick = personFactory.create(1, "Nick");
		Assert.assertEquals(1, nick.getId());
		Assert.assertEquals("Nick", nick.getName());
	}
}



