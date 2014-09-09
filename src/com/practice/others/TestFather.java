package com.practice.others;

public class TestFather {
    public TestFather(int m1, int m2) {
        this();
        System.out.println(m1 + "  " + m2);
    }

    public TestFather() {
        // this(1,2);

    }

    protected String outPut(String m1) {
        return m1;
        // System.out.print(m1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TestFather test = new TestFather();
        test.outPut("12");
        System.out.print(true);
    }

}
