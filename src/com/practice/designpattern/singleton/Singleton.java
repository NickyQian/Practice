package com.practice.designpattern.singleton;

public class Singleton {
    private static Singleton uniqueInstance;
    
    private Singleton() {}
    
    public synchronized static Singleton getInstance() {
        
        /* 延迟实例化 */
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
