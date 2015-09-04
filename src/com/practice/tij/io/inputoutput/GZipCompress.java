package com.practice.tij.io.inputoutput;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.junit.AfterClass;
import org.junit.Test;

public class GZipCompress {
	private static String INPUT_FILE = "./src/com/practice/tij/io/inputoutput/GZipCompress.java";
	private static String COMPRESSED_FILE = "test.gz";
	@Test
	public void test() throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(COMPRESSED_FILE)));
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();

		System.out.println("Reading file:");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(
				new FileInputStream(COMPRESSED_FILE))));
		String line;
		while ((line = in2.readLine()) != null) {
			System.out.println(line);
		}
		in2.close();
	}
	
	@AfterClass
	public static void tearDown() {
		new File(COMPRESSED_FILE).delete();
	}
}
