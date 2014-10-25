package com.practice.concurrency.container;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/*
 * CocurrentLinkedQueue是一种线程安全却非阻塞的FIFO队列
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) throws Exception {
        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        for (int i = 0; i < 100; i++) {
            queue.add(String.valueOf(i));
        }
        int num = 10;// 线程人个数
        for (int i = 0; i < num; i++) {
            new ConsumerThread(queue);
        }

    }

    public static class ConsumerThread implements Runnable {
        Queue<String> queue;

        public ConsumerThread(Queue<String> queue) {
            this.queue = queue;
            Thread thread = new Thread(ConsumerThread.this);
            thread.start();
        }

        public void run() {
            String value;
            long startDate = new Date().getTime();
            long endDate = new Date().getTime();
            while ((value = queue.poll()) != null) {
                System.out.print("get one: " + value + "   线程名：" + Thread.currentThread().getName());
                System.out.print("\t");
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
                endDate = new Date().getTime();
            }
            System.out.println("花费时间：" + (endDate - startDate) +"   线程名：" + Thread.currentThread().getName());

        }
    }
}