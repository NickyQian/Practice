package com.practice.concurrency.cas;

import org.junit.Assert;
import org.junit.Test;

public class CasCounter {

    private final class SimulatedCAS {
        private int value;

        public synchronized int get() {
            return this.value;
        }

        public synchronized int compareAndSwap(int expectedValue, int newValue) {
            int oldValue = value;
            if (oldValue == expectedValue) {
                value = newValue;
            }
            return oldValue;
        }

        public synchronized boolean compareAdnSet(int expectedValue,
                int newValue) {
            return (expectedValue == compareAndSwap(expectedValue, newValue));
        }
    }

    private SimulatedCAS value = new SimulatedCAS();

    public int getValue() {
        return value.get();
    }

    /**
     * 
     * @return return old value not the increased value.
     */
    public int count() {
        int result;
        boolean flag;
        do {
            result = value.get();
            // 单线程下, compareAndSet返回永远为true,
            // 多线程下, 在与result进行compare时, counter可能被其他线程set了新值, 这时需要重新再取一遍再比较,
            // 如果还是没有拿到最新的值, 则一直循环下去, 直到拿到最新的那个值
            flag = value.compareAdnSet(result, result + 1); // 设置的最新值在value中
                                                            // ，通过value.get()可以得到
        } while (!flag);

        return result;
    }

    public int increment() {
        int v;
        do {
            v = getValue();
        } while (v != value.compareAndSwap(v, v + 1));
        return v + 1;
    }

    @Test
    public void test() {
        CasCounter casCounter = new CasCounter();
        Assert.assertEquals(1, casCounter.increment());
    }

}
