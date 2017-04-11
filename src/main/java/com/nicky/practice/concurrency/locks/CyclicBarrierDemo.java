package com.nicky.practice.concurrency.locks;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier类似于CountDownLatch也是个计数器，
 * 不同的是CyclicBarrier数的是调用了CyclicBarrier.await
 * ()进入等待的线程数，(CountDwonLath是countDown方法)
 * 当线程数达到了CyclicBarrier初始时规定的数目时，所有进入等待状态的线程被唤醒并继续。
 * CyclicBarrier就象它名字的意思一样，可看成是个障碍， 所有的线程必须到齐后才能一起通过这个障碍。
 * CyclicBarrier初始时还可带一个Runnable的参数，
 * 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程$被唤醒前$被执行。
 */
public class CyclicBarrierDemo {

    public static class Person implements Runnable {
        CyclicBarrier barrier;
        int ID;

        public Person(CyclicBarrier barrier, int ID) {
            this.barrier = barrier;
            this.ID = ID;
        }

        public void run() {
            try {
                System.out.println("Person [" + ID + "] is coming.");
                // 在这里等待Barrier处
                Random random = new Random();
                long randomValue = random.nextInt(10) * 1000;
                Thread.sleep(randomValue);
                System.out.println("Person [" + ID + "] is waiting.");
                barrier.await();
                System.out.println("Person [" + ID + "] is leaving.");
            } catch (Exception ex) {
            }
        }
    }

    /** */
    /**
     * 测试CyclicBarrier的用法
     */
    public static void testCyclicBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            // 在所有线程都到达Barrier时执行
            public void run() {
                System.out.println("We got two person, let's go.");
            }
        });

        // 启动线程
        for (int i = 0; i < 8; i++)
            new Thread(new Person(barrier, i)).start();
    }

    public static void main(String[] args) {
        CyclicBarrierDemo.testCyclicBarrier();
    }
}
