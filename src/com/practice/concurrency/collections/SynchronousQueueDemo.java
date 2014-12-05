package com.practice.concurrency.collections;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<String> syncQueue = new SynchronousQueue<String>();

        System.out.println(syncQueue.offer("2"));
        System.out.println(syncQueue.offer("3"));
        System.out.println(syncQueue.offer("4"));
        System.out.println(syncQueue.offer("5"));
        System.out.println(syncQueue.offer("6"));

        new Thread() {

            @Override
            public void run() {
                String s = null;
                try {
                    s = syncQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s);
            }

        }.start();

        new Thread() {

            @Override
            public void run() {
                boolean flag = syncQueue.offer("2");
                System.out.println(flag);
            }

        }.start();

        Thread.sleep(2000);
        System.out.println("End");
    }
}
