package com.nicky.practice.tij.io.filewalker;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}

	public static void main(String[] args) {
		File path = new File(".");
		String regex = ".*";
		// listFiles return File Objects array
		File[] list = path.listFiles(filter(regex));
		for (File file : list) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("===");
		// list return file/directory names
		String[] filePaths = path.list();
		Arrays.sort(filePaths, String.CASE_INSENSITIVE_ORDER);
		for (String s : filePaths)
			System.out.println(s);
	}
}
