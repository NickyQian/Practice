package com.nicky.practice.tij.io.serialization;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ReferenceInSerializationTest {

	@Test
	@SuppressWarnings("rawtypes")
	public void test() throws IOException, ClassNotFoundException {
		House house = new House();
		List<Animal> animals = Lists.newArrayList(new Animal("dog", house), new Animal("cat", house), new Animal(
				"hamaster", house));
		System.out.println("animals" + animals);
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals);
		o1.writeObject(animals); // Write same array again
		// Write to a different stream.
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
		List animals1 = (List) in1.readObject();
		List animals2 = (List) in1.readObject();
		List animals3 = (List) in2.readObject();
		System.out.println("animals1" + animals1);
		System.out.println("animals2" + animals2);
		System.out.println("animals3" + animals3);

		assertTrue(animals1 == animals2);
		assertFalse(animals1 == animals3);
	}
}

class House implements Serializable {

	private static final long serialVersionUID = 1L;
}

class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private House preferredHouse;

	Animal(String nm, House h) {
		name = nm;
		preferredHouse = h;
	}

	public String toString() {
		return name + "[" + super.toString() + "], " + preferredHouse + "\n";
	}
}
