package com.nicky.practice.designpattern.strategy;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("This is FlyNoWay: can't fly! ");
        
    }
    
}
