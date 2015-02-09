package com.practice.io.nio2;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.EnumSet;

import org.junit.Test;

//java7 NIO2使用walk递归接口递归操作文件，
//可以使用这个接口进行文件搜索，文件内容搜索，递归拷贝，递归移动，递归删除等操作。
public class NIO2FileWalk {

	@Test
	public void testListTree() {
		Path listDir = Paths.get("c:\\Download"); // define the starting file
		//
		ListTree walk = new ListTree();
		try {
			Files.walkFileTree(listDir, walk);
		} catch (IOException e) {
			System.err.println(e);
		}

		// 遍历的时候跟踪链接
		EnumSet<FileVisitOption> opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
		 
		try {
			Files.walkFileTree(listDir, opts, Integer.MAX_VALUE, walk);
		} catch (IOException e) {
			System.err.println(e);
		}
		// FileVisitor 提供perform a file search, a recursive copy, arecursive
		// move, and a recursive delete.
	}
}

class ListTree extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
		System.out.println("Visited directory: " + dir.toString());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) {
		System.out.println(exc);
		return FileVisitResult.CONTINUE;
	}
}
