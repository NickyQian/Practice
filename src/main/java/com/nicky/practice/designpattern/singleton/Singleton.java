package com.nicky.practice.designpattern.singleton;
/**
 * 单例模式：
 * 确保一个类只有一个实例，
 * 并提供一个全局的访问点。
 * @author qianlei
 *
 */
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
