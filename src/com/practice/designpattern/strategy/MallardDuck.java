package com.practice.designpattern.strategy;

public class MallardDuck extends Duck {
    // 针对不同的类型 初始化的时候赋予不同的行为功能！
    public MallardDuck() {
        setFlyBehavior(new FlyHigh());
        setQuackBehavior(new Quack());
    }
    
    public void balabla() {
        System.out.println("This is balabala.");
    }
}
