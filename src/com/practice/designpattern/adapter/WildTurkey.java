package com.practice.designpattern.adapter;

public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble gobble......"); // 野火鸡只会咯咯叫
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance."); // 飞行距离相对比较短
    }
}
