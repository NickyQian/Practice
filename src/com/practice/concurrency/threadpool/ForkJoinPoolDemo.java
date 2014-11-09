package com.practice.concurrency.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import org.junit.Test;

public class ForkJoinPoolDemo {

    @Test
    public void testFibonacci() throws InterruptedException, ExecutionException {
        System.out.println("start");
        ForkJoinTask<Integer> fjt = new Fibonacci(12);
        ForkJoinPool fjpool = new ForkJoinPool();
        System.out.println("start1");
        Future<Integer> result = fjpool.submit(fjt);
        System.out.println("Do other things...");

        System.out.println(result.get());
    }
    
    @SuppressWarnings("serial")
    class Fibonacci extends RecursiveTask<Integer> {
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        private int compute(int small) {
            final int[] results = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
            return results[small];
        }

        public Integer compute() {
            if (n <= 10) {
                return compute(n);
            }
            Fibonacci f1 = new Fibonacci(n - 1);
            Fibonacci f2 = new Fibonacci(n - 2);
            f1.fork();
            f2.fork();
            return f1.join() + f2.join();
        }
    }

}
