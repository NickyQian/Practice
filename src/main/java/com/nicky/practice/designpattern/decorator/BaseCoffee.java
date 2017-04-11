package com.nicky.practice.designpattern.decorator;
/**
 * 基本咖啡
 * @author qianlei
 *
 */
public abstract class BaseCoffee {
    private String description = "Base Coffe!";
    
    public abstract float cost();
    
    public String getDescription() {
        return description;
    }
}
