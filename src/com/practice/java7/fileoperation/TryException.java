package com.practice.java7.fileoperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

public class TryException {
	private String inputFilePath = "C:\\Download\\file1.txt";
	private String outputFilePath = "C:\\Download\\copyOfFie1.txt";

	@Test
	public void testTryException() {
		// if output file doesn't exist, will create a new file.
		// java7 new feature: written in try block, dont need to close file
		// stream.
		try (FileInputStream input = new FileInputStream(inputFilePath);
				FileOutputStream output = new FileOutputStream(outputFilePath)) {
			int b;
			while ((b = input.read()) > 0) { // read one byte by one byte.
				output.write(b);
			}
			System.out.println("File Copy Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOtherStream() {
		File inputFile = new File(inputFilePath);
		File outputFile = new File(outputFilePath);
		try (BufferedReader read = new BufferedReader(new FileReader(inputFile));
				BufferedWriter witer = new BufferedWriter(new FileWriter(outputFile));) {
			String s = null;
			while ((s = read.readLine()) != null) {
				System.out.println(s);
				witer.write(s);
				witer.write("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
