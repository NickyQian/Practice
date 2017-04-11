package com.nicky.practice.designpattern.decorator;

public class MochaDecorator extends Decorator {
    private BaseCoffee coffee;
    
    public MochaDecorator(BaseCoffee coffee) {
        this.coffee = coffee;
    }
    /**
     * 摩卡 需要多加0.5美元
     */
    @Override
    public float cost() {
        return 0.5f + coffee.cost();
    }
    
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return coffee.getDescription()+ ", adding mocha";
    }
}
