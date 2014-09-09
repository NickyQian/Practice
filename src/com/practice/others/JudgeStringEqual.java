package com.practice.others;

/*
 * ̽探讨String 判断 == 的结果
 */
public class JudgeStringEqual {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "abc";
        String b = "ab" + "c";
        String c = new String(a);
        String d = "abc";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a.equals(c));

        System.out
                .println("------------------- String ----------------------------");
        String hello = "Hello", lo = "lo";
        System.out.println("1 :" + (hello == "Hello") + " ");
        System.out.println("2 :" + (Other.hello == hello) + " ");
        System.out.println("3 :" + (hello == ("Hel" + "lo")) + " ");
        System.out.println("4 :" + (hello == ("Hel" + lo)) + " "); // false!
        System.out.println("5 :" + (hello == ("Hel" + lo).intern())); // true!
    }
}

class Other {
    static String hello = "Hello";
}
