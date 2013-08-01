package com.practice.designpattern.strategy;

public class Test {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        // 动态修改了mallard duck的行为， 设置成为不能飞。
        mallardDuck.setFlyBehavior(new FlyNoWay());
        mallardDuck.performFly();
    }

}
