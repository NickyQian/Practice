package com.nicky.practice.designpattern.decorator;
/**
 * 深度烘焙咖啡
 * @author qianlei
 *
 */
public class DarkRoast extends BaseCoffee {

    @Override
    public float cost() {
        // TODO Auto-generated method stub
        return 0.99f;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Dark Roast Coffee";
    }
    
}
