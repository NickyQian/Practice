package com.nicky.practice.designpattern.decorator;

public class MilkDecorator extends Decorator {
    private BaseCoffee coffee;
    
    /* 必须要有一个基础咖啡 */
    public MilkDecorator(BaseCoffee coffee) {
        this.coffee = coffee;
    }
    /**
     * 加奶 加价0.2美元
     */
    @Override
    public float cost() {
        return 0.2f + coffee.cost();
    }
    
    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return coffee.getDescription()+ ", adding milk";
    }
}
