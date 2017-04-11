package com.nicky.practice.designpattern.singleton;

/**
 * 双重检查枷锁后的单例模式 可以避免多次受synchronized影响效率
 * 
 * @author qianlei
 *
 */
public class SingletonVolatile {
	/*
	 * volatile关键词确保： 当unqiueInstance变量被 初始化成SingletonVolatile实例时，多个线程
	 * 正确处理uniqueInstance变量
	 */
	private volatile static SingletonVolatile uniqueInstance;

	private SingletonVolatile() {
	}

	/* 此方法去除了synchronized关键字 移到方法体里面了 */
	public static SingletonVolatile getInstance() {

		/* 延迟实例化 */
		if (uniqueInstance == null) {
			synchronized (SingletonVolatile.class) { // 只有第一次才彻底执行到这里的代码
				if (uniqueInstance == null) {
					uniqueInstance = new SingletonVolatile();
				}
			}
		}
		return uniqueInstance;
	}
}
