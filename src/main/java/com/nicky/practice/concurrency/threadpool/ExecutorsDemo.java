package com.nicky.practice.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorsDemo {
    private class TestThread extends Thread {
        private int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Current thread: ["
                    + Thread.currentThread().getName() + "], Id: [" + id
                    + "] is running...");
        }
    }

    private void runThread(ExecutorService pool) {
        int threadCount = 5;
        for (int i = 0; i < threadCount; i++) {
            Thread t = new TestThread(i + 1);
            pool.execute(t);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        pool.shutdown();
    }

    @Test
    /**
     * 固定大小的线程池
     */
    public void testNewFixedThreadPool() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        runThread(pool);
    }

    @Test
    public void testSingleThreadExecutor() {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        runThread(pool);
    }

    @Test
    /**
     * 这种方式的特点是：可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
     */
    public void testNewCachedThreadPool() {
        ExecutorService pool = Executors.newCachedThreadPool();
        runThread(pool);
    }

    @Test
    public void testNewScheduledThreadPool() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        Thread t1 = new TestThread(1);
        Thread t2 = new TestThread(2);
        Thread t3 = new TestThread(3);
        Thread t4 = new TestThread(4);
        pool.execute(t1);
        // 使用延迟执行风格的方法
        pool.schedule(t2, 1000, TimeUnit.MILLISECONDS);
        pool.schedule(t3, 2000, TimeUnit.MILLISECONDS);
        pool.schedule(t4, 50, TimeUnit.MILLISECONDS);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pool.shutdown();
    }

    @Test
    public void testStartThreadInPoolThread() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(new Runnable() {

            @Override
            public void run() {
                System.out.println("start a new thread....first level.");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out
                                .println("start a new thread....first leve2.");
                    }

                }).start();

            }

        });
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
