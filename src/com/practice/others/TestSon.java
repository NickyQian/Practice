package com.practice.others;

public class TestSon extends TestFather {
    public TestSon() {
        super(1, 2);
        System.out.println("sdfs");
    }

    public static void main(String[] args) {
        TestFather test = new TestFather();
        TestSon testSon = new TestSon();
        test.outPut("ok");
        testSon.outPut("OK");
    }
}
