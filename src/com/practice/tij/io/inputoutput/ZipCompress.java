package com.practice.tij.io.inputoutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.AfterClass;
import org.junit.Test;

import com.google.common.collect.Lists;

public class ZipCompress {
	private static final String COMPRESSED_FILE = "test.zip";
	private List<String> fileList = Lists.newArrayList("./src/com/practice/tij/io/inputoutput/ZipCompress.java",
			"./src/com/practice/tij/io/inputoutput/MemoryInput.java");

	@Test
	public void test() throws IOException {
		FileOutputStream f = new FileOutputStream(COMPRESSED_FILE);
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());

		ZipOutputStream zos = new ZipOutputStream(f);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping...");
		for (String file : fileList) {
			System.out.println("Writing file: " + file);
			BufferedReader in = new BufferedReader(new FileReader(file));
			zos.putNextEntry(new ZipEntry(file));
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			in.close();
			out.flush();
		}
		out.close();
		// Checksum valid only after the tile has been closed!
		System.out.println("Checksum: " + csum.getChecksum().getValue());
		// Extract the files:
		FileInputStream fi = new FileInputStream(COMPRESSED_FILE);
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while ((ze = in2.getNextEntry()) != null) {
			System.out.println("Reading file" + ze);
			int x;
			while ((x = bis.read()) != -1) {
				System.out.write(x);
			}
		}
		System.out.println("Checksum: " + csumi.getChecksum().getValue());
		bis.close();
		// Alternative way to open and read Zip files
		ZipFile zf = new ZipFile(COMPRESSED_FILE);
		Enumeration<?> e = zf.entries();
		while (e.hasMoreElements()) {
			ZipEntry ze2 = (ZipEntry) e.nextElement();
			System.out.println("File:" + ze2);
		}
		zf.close();
	}
	
	@AfterClass
	public static void tearDown() {
		new File(COMPRESSED_FILE).delete();
	}
}
