package com.nicky.practice.tij.io.inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class BasicFileOutput {
	static String outputFile = "./src/com/practice/tij/io/inputoutput/BasicFileOutput.out";
	static String orgFile = "./src/com/practice/tij/io/inputoutput/BasicFileOutput.java";

	@Test
	public void test() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(orgFile));
		File outputFileObject = new File(outputFile);
		PrintWriter out = new PrintWriter(outputFileObject);
		int lineCount = 1;
		String s;
		while ((s = in.readLine()) != null) {
			out.println(lineCount++ + ": " + s);
		}
		out.close();
		in.close();
		System.out.println(BufferedInputFile.read(outputFile));
		outputFileObject.delete();
	}
}
