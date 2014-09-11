package com.practice.concurrency.threadpool;

import java.lang.reflect.Field;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectedExecutionDemo {
    static void log(String msg) {
        System.out.println(System.currentTimeMillis() + " -> " + msg);
    }

    static int getThreadPoolRunState(ThreadPoolExecutor pool) throws Exception {
        Field f = ThreadPoolExecutor.class.getDeclaredField("runState");
        f.setAccessible(true);
        int v = f.getInt(pool);
        return v;
    }

    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));
         pool.setRejectedExecutionHandler(new
         ThreadPoolExecutor.DiscardPolicy());
        // pool.setRejectedExecutionHandler(new
        // ThreadPoolExecutor.CallerRunsPolicy());
        // pool.setRejectedExecutionHandler(new
        // ThreadPoolExecutor.AbortPolicy());
        // pool.setRejectedExecutionHandler(new
        // ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 10; i++) {
            final int index = i;
            pool.submit(new Runnable() {

                public void run() {
                    log("run task:" + index + " -> "
                            + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    log("run over:" + index + " -> "
                            + Thread.currentThread().getName());
                }
            });
        }
        log("before sleep");
        Thread.sleep(4000L);
        log("before shutdown()");
        pool.shutdown();
        log("after shutdown(),pool.isTerminated=" + pool.isTerminated());
        pool.awaitTermination(1000L, TimeUnit.SECONDS);
        log("now,pool.isTerminated=" + pool.isTerminated() + ", state="
                + getThreadPoolRunState(pool));
    }
}
