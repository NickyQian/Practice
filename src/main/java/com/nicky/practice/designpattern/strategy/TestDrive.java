package com.nicky.practice.designpattern.strategy;
/**
 * 策略模式：
 * 定义了算法族，让它们之间可以互换，
 * 此模式让算法的变化独立与使用算法的客户。
 * @author qianlei
 *
 */
public class TestDrive {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        // 动态修改了mallard duck的行为， 设置成为不能飞。
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.performFly();
    }

}
