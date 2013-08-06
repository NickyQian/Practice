package com.practice.designpattern.singleton;
/**
 * 急切方法的单例模式
 * @author qianlei
 *
 */
public class SingletonEarly {
    private static SingletonEarly singleton;
    
    private SingletonEarly(){}
    
    public static SingletonEarly getInstance() {
        return singleton;
    }
}
