package com.nicky.practice.tij.io.inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.AfterClass;
import org.junit.Test;

public class GetChannel {

	private static final String INPUT_FILE = "./src/com/practice/tij/io/inputoutput/GetChannel.java";
	private static final String OUTPUT_FILE = "./src/com/practice/tij/io/inputoutput/data.out";

	@Test
	public void testFileChannelFileOutputStream() throws IOException {
		FileOutputStream out = new FileOutputStream(OUTPUT_FILE);
		FileChannel fc = out.getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		out.close();
		fc.close();
	}

	@Test
	public void testFileChannelFileInputStream() throws IOException {
		final int BSIZW = 2;
		FileInputStream in = new FileInputStream(INPUT_FILE);
		FileChannel fc = in.getChannel();
		FileOutputStream out = new FileOutputStream(OUTPUT_FILE);
		FileChannel fcOut = out.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZW);
		while (fc.read(buff) > 0) {
			buff.flip();
			fcOut.write(buff);
			buff.clear();
		}
		while (buff.hasRemaining())
			System.out.print((char) buff.get());
		in.close();
		fc.close();
		out.close();
		fcOut.close();
	}

	@Test
	public void testTransferTo() throws IOException {
		FileInputStream in = new FileInputStream(INPUT_FILE);
		FileChannel fc = in.getChannel();
		FileOutputStream out = new FileOutputStream(OUTPUT_FILE);
		FileChannel fcOut = out.getChannel();
		// or:
		// fcOut.transferFrom(fc, 0, fc.size());
		fc.transferTo(0, fc.size(), fcOut);
		in.close();
		out.close();
	}

	@AfterClass
	public static void deleteFile() {
		new File(OUTPUT_FILE).delete();
	}
}
