package com.nicky.practice.java7.fileoperation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class IONewFeature {

	Path path = FileSystems.getDefault().getPath("c:\\Download", "file1.txt");

	@Test
	public void testPath() {
		// 获得path方法一
		System.out.println(path.getNameCount());
		// 获得path方法二，用File的toPath()方法获得Path对象
		File file = new File("c:\\Download\\file1.txt");
		Path pathOther = file.toPath();
		// 0, 说明这两个path是相等的
		Assert.assertEquals(0, path.compareTo(pathOther));
		// 获得path方法三
		// join them with file sysytem seperator
		Path path3 = Paths.get("c:\\Download", "copyOfFile1.txt");
		System.out.println(path3.toString());
		// java7的新特性，写入try中不用自己关闭流
		// 注意此处的newBufferedRead的charset参数，如果和所要读取的文件的编码不一致，则会抛出异常
		// new BufferedReader(new FileReader(new
		// File("c:\\Download\\file1.txt"))); // old code
		try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
				BufferedWriter wr = Files.newBufferedWriter(path3, StandardOpenOption.CREATE)) {
			// BufferedWriter wr = Files.newBufferedWriter(path3,
			// StandardOpenOption.APPEND)){
			if (Files.isReadable(path)) {
				String line = "";
				while ((line = br.readLine()) != null) {
					wr.write(line);
					wr.write("\n");
					System.out.println(line);
				}
			} else {
				System.err.println("cannot readable");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error");
		}
	}

	@Test
	public void testFilesWrite() {

		List<String> lines = new ArrayList<>();
		lines.add("line1 ");
		lines.add("line2");
		lines.add("line3");
		try {
			// Write lines of text to a file.
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
