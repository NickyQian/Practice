package com.nicky.practice.designpattern.decorator;
/**
 * 速溶咖啡
 * @author qianlei
 *
 */
public class Espresso extends BaseCoffee {

    @Override
    public float cost() {
        // TODO Auto-generated method stub
        return 0.89f;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Espresso";
    }

}
