package com.nicky.practice.java8.fucntionalInterface;

public interface PersonFactory<P extends Person> {
	P create(int id, String name);
}
