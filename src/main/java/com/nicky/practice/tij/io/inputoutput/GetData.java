package com.nicky.practice.tij.io.inputoutput;

import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;

import org.junit.Assert;
import org.junit.Test;

public class GetData {
	private static final int BSIZE = 1024;

	@Test
	public void testByteBuffer() {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		// Allocation automatically zeroes the ByteBuffer
		int i = 0;
		while (i++ < bb.limit()) {
			if (bb.get() != 0) {
				System.out.println("NonZero");
				Assert.fail();
			}
		}
		System.out.println("i = " + i);
		assertEquals(BSIZE + 1, i);

		bb.rewind();
		bb.asCharBuffer().put("Howdy");
		char c;
		while ((c = bb.getChar()) != 0) {
			System.out.print(c + " ");
		}
		System.out.print("\n");
	}
}









