package com.nicky.practice.stringchar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringAndChar {
	@Test
	public void testStringChar() {
		String s = "hello";
		String str = "hello";
		char c[] = { 'h', 'e', 'l', 'l', 'o' };
		char[] h = { 'h', 'e', 'l', 'l', 'o' };
		char ch[] = str.toCharArray();

		System.out.println("ch==c: " + (ch == c)); // false
		System.out.println("ch.equals(c): " + (ch.equals(c))); // false
		System.out.println("ch.equals(h): " + (ch.equals(h))); // false

		String s2 = new String(c); // char转成String
		System.out.println("s2==s: " + (s2 == s)); // false
		System.out.println("s2.equals(s): " + (s2.equals(s))); // true
	}

	@Test
	public void testStringIntern() {
		String testStr1 = "a"; // automatically call intern method
		String testStr2 = "a".intern();
		String testStr3 = "a";
		String str1 = new String("a");
		String str2 = new String("a");
		String strIntern1 = new String("a").intern();
		String strIntern2 = new String("a").intern();

		assertEquals(true, testStr1 == testStr2);
		assertEquals(false, str1 == str2);
		assertEquals(true, testStr1 == testStr3);
		assertEquals(false, str1 == strIntern1);
		assertEquals(true, strIntern1 == strIntern2);
		assertEquals(true, testStr1 == strIntern1);
	}
	
	@Test
	public void testArray() {
		
	}
}
