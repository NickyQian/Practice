package com.nicky.practice.concurrency.atomic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * 对array atomic变量来说，一次只有一个索引变量可以变动，并没有功能可以对整个array做atomic化的变动。
 * 
 * @author lq00863
 *
 */
public class AtomicIntegerTest {
    @Test
    public void testAll() throws InterruptedException {
        final AtomicInteger value = new AtomicInteger(10);
        assertEquals(value.compareAndSet(1, 2), false);
        assertEquals(value.get(), 10);
        assertTrue(value.compareAndSet(10, 3));
        assertEquals(value.get(), 3);
        value.set(0);

        assertEquals(value.incrementAndGet(), 1);
        assertEquals(value.getAndAdd(2), 1);
        assertEquals(value.getAndSet(5), 3);
        assertEquals(value.get(), 5);

        final int threadSize = 100;
        Thread[] ts = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            ts[i] = new Thread() {
                public void run() {
                    value.incrementAndGet();
                }
            };
        }

        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            t.join();
        }

        assertEquals(value.get(), 5 + threadSize);
    }
}
