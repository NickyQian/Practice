package com.nicky.practice.designpattern.factoryAndabstractFactory.pizza;

public abstract class Pizza {
    private String name = "ordinary pizza";
    
    public abstract void prepar();
    
    public void bake() {
        System.out.println("Begin baking......");
    }
    public void cut() {
        System.out.println("Begin cuting......");
    }
    public void box() {
        System.out.println("Begin boxing......");
    }
    public void mail() {
        System.out.println("Finished and mail it.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
