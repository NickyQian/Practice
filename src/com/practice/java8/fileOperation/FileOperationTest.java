package com.practice.java8.fileOperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class FileOperationTest {
	@Test
	public void testFileWalker() throws IOException {
		Files.walk(Paths.get("C:\\test")).filter(p -> !p.toFile().getName().contains("(1)"))
				.forEach(System.out::println);
	}

}
