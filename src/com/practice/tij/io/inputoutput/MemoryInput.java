package com.practice.tij.io.inputoutput;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class MemoryInput {
	private static final String CLASS_FILE_PATH = "./src/com/practice/tij/io/inputoutput/MemoryInput.java";

	@Test
	public void test() throws IOException {
		ClassLoader loader = MemoryInput.class.getClassLoader();
		System.out.println(loader.getResource("com/practice/tij/io/inputoutput/MemoryInput.class"));
		String path = MemoryInput.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		System.out.println(path);
		StringReader in = new StringReader(BufferedInputFile.read(CLASS_FILE_PATH));
		int c;
		while ((c = in.read()) != -1) {
			System.out.print((char) c);
		}
	}
	
	@Test
	public void dataInputStreamTest() throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(CLASS_FILE_PATH)));
		while(in.available() != 0) {
			System.out.print((char) in.readByte());
		}
		in.close();
	}
}
