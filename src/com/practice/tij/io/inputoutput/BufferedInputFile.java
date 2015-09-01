package com.practice.tij.io.inputoutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class BufferedInputFile {
	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}

	@Test
	public void test() throws IOException {
		System.out.println(read("./src/com/practice/tij/io/inputoutput/BufferedInputFile.java"));
		// LinkedList<String> linked = new LinkedList<String>();
		// linked.removeLast();
	}
}
