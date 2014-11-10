package com.practice.concurrency.volatiledemo;

public class VolatileDemo {
    int x = 0;
    volatile boolean v = false;

    public void writer() {
        x = 42;
        v = true;// if v is not volative, maybe reordered to first.
    }

    public void reader() {
        if (v == true) {
            // uses x - guaranteed to see 42.
            System.out.println("x");
        }
    }

    // public static void main(String[] args) {
    //
    // }
}
