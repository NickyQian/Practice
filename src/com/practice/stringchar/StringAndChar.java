package com.practice.stringchar;

public class StringAndChar {
    public static void main(String[] args) {
        String s = "hello";
        String str = "hello";
        char c[] = {'h','e','l','l','o'};
        char[] h = {'h','e','l','l','o'};
        char ch[] = str.toCharArray();
        
        System.out.println("ch==c: " + (ch==c));                // false
        System.out.println("ch.equals(c): " + (ch.equals(c)));  // false
        System.out.println("ch.equals(h): " + (ch.equals(h)));  // false
        
        String s2 = new String(c); // char转成String
        System.out.println("s2==s: " + (s2==s));                // false
        System.out.println("s2.equals(s): " + (s2.equals(s)));  // true
    }
}
