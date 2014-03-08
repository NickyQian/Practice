package com.practice.regularexpresssion;

public class SplitWithRegex {

    public static void main(String[] args) {
        String str = "2006-04-15 02:31:04";
        String str2 = "";
        String regex = "\\D";// \D 相当于 ^[0-9]
        String[] resultStr = str.split(regex);
        for (int i = 0; i < resultStr.length; i++) {
            System.out.print(resultStr[i]);
            str2 += resultStr[i];
        }
        System.out.println("");
        System.out.println(str2);
    }
}
