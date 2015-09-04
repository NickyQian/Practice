package com.practice.tij.io.inputoutput;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.IntStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sun.nio.ch.DirectBuffer;

public class LargeMappedFiles {

	private static final int length = 256; // 256k
	private static final String FILE_PATH = "./src/com/practice/tij/io/inputoutput/LargeMappedFiles.out";

	private static File file = new File(FILE_PATH);

	@BeforeClass
	public static void setUp() throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
	}

	@Test
	public void test() throws IOException {
		RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");
		FileChannel ch = file.getChannel();
		MappedByteBuffer out = ch.map(FileChannel.MapMode.READ_WRITE, 0, length);
		ch.read(out);
		IntStream.range(0, length).forEach(i -> out.put((byte) i));
		System.out.println("Finished writing.");
		System.out.println((char) out.get(length - 1));
		out.clear();
		// FileChannel map will still there even if it is closed.
		// A mapped byte buffer and the file mapping that it represents remain
		// valid until the buffer itself is garbage-collected.
		((DirectBuffer) out).cleaner().clean();
		file.close();
		ch.close();
	}

	@AfterClass
	public static void tearDown() throws IOException {
		boolean isDeleted = file.delete();
		System.out.println(isDeleted);
	}
}
