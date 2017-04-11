package com.nicky.practice.concurrency.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * http://www.infoq.com/cn/articles/ConcurrentHashMap
 * 
 * 效率低下的HashTable容器
 * 
 * HashTable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下HashTable的效率非常低下。
 * 因为当一个线程访问HashTable的同步方法时，其他线程访问HashTable的同步方法时，
 * 可能会进入阻塞或轮询状态。如线程1使用put进行添加元素，线程2不但不能使用put方法添加元素,
 * 并且也不能使用get方法来获取元素，所以竞争越激烈效率越低
 * 
 * 锁分段技术
 * 
 * HashTable容器在竞争激烈的并发环境下表现出效率低下的原因是所有访问HashTable的线程都必须竞争同一把锁，那假如容器里有多把锁，
 * 每一把锁用于锁容器其中一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，从而可以有效的提高并发访问效率，
 * 这就是ConcurrentHashMap所使用的锁分段技术,
 * 首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。
 * 
 * @author lq00863
 *
 */
public class ConcurrentMapDemo {
    static ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
    HashMap<String, String> hashMap = new HashMap<String, String>();
//    public static void main(String[] args) {
//        int ssize = 1;
//        ssize <<= 4;
//        System.out.println(ssize);
//    }

}
