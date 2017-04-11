package com.nicky.practice.tij.io.inputoutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFile {
	public static byte[] read(File bFile) throws IOException {
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(bFile));
		try {
			byte[] b = new byte[br.available()];
			br.read(b);
			return b;
		} finally {
			br.close();
		}
	}

	private static final String OUTPUT_PATH = "./src/com/practice/tij/io/inputoutput/BinaryFile.out";

	public static void write(File bFile) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(OUTPUT_PATH));
		byte[] b = new byte[1024];
		try {
			int len;
			while ((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
		} finally {
			in.close();
			out.close();
			System.out.println(BufferedInputFile.read(OUTPUT_PATH));
			new File(OUTPUT_PATH).delete();
		}
	}

	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile).getAbsoluteFile());
	}

	public static void main(String[] args) throws IOException {
		write(new File("./src/com/practice/tij/io/inputoutput/GetChannel.java"));
	}
}
