package com.practice.tij.io.inputoutput;

import java.io.PrintWriter;

public class ChangeSystemOut {
	public static void main(String[] args) {
		// true -> auto flush
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Hello World!");
	}
}
