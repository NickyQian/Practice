package com.practice.designpattern.strategy;

public class FlyHigh implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("This is FlyHigh: fly high! ");

    }

}
