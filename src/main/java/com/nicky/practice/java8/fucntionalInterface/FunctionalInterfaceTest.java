package com.nicky.practice.java8.fucntionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    @Test
    public void comparatorTest() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(2, "Nick"));
        persons.add(new Person(4, "Aick"));
        persons.add(new Person(1, "Cick"));
        persons.add(new Person(3, "Dick"));
        persons.add(new Person(7, "Hick"));
        persons.add(new Person(7, "Aick"));
        persons.add(new Person(7, "Bick"));
        Collections.sort(persons, Comparator.comparing(Person::getId)
                .thenComparing(Person::getName));
        persons.forEach((a) -> System.out.println("ID: " + a.getId() + ", Name: " + a.getName()));

    }
}
