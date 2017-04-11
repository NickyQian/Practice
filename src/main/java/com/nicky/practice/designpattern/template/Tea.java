package com.nicky.practice.designpattern.template;

public class Tea extends BaseCoffineDrink {

    /**
     * 茶 需要浸泡
     */
    @Override
    public void brew() {
        System.out.println("Steeping the tea.");
    }
    /**
     * 茶 加入调料为柠檬
     */
    @Override
    public void addCondiments() {
        System.out.println("Adding Lemon");
    }

}
