package com.practice.designpattern.decorator;
/**
 * 咖啡装饰类
 * @author qianlei
 *
 */
public abstract class Decorator extends BaseCoffee {
    // 重新实现getDescription
    public abstract String getDescription();
}
