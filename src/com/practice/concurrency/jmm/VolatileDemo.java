package com.practice.concurrency.jmm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class VolatileDemo {
    public int x = 0;
    // volatile boolean v = false;
    boolean v = false;

    public void writer() {
        x = 42;
        v = true; // if v is not volative, dont exist data dependency, maybe
                  // reordered to first.
    }

    public void reader() {
        System.out.println("start reader");
        if (v) {
            System.out.println("reader:" + x);
        } else {
            System.out.println("x is not ready");
        }
        System.out.println("end reader");
    }

    @Test
    public void test() throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new Reader(demo));
        pool.submit(new Writer(demo));
        pool.shutdown();
        Thread.sleep(2000);
    }

    public class Writer implements Runnable {

        private VolatileDemo volatileDemo;

        public Writer(VolatileDemo volatileDemo) {
            this.volatileDemo = volatileDemo;
        }

        @Override
        public void run() {
            volatileDemo.writer();
        }

    }

    public class Reader implements Runnable {

        private VolatileDemo volatileDemo;

        public Reader(VolatileDemo volatileDemo) {
            this.volatileDemo = volatileDemo;
        }

        @Override
        public void run() {
            volatileDemo.reader();
        }

    }
}
