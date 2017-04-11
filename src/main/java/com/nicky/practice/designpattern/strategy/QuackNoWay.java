package com.nicky.practice.designpattern.strategy;

public class QuackNoWay implements QuackBehavior {

    @Override
    public void quack() {
        // TODO Auto-generated method stub
        System.out.println("This is QuackNoWay: can't quack! ");
    }

}
