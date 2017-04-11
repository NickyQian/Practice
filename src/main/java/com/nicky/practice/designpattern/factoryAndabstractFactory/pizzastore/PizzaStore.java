package com.nicky.practice.designpattern.factoryAndabstractFactory.pizzastore;

import com.nicky.practice.designpattern.factoryAndabstractFactory.pizza.Pizza;

public abstract class PizzaStore {

    public void orderPizzza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepar();
        pizza.bake();
        pizza.cut();
        pizza.box();
        pizza.mail();
    }
    /**
     * 工厂模式 ：方法留给子类工厂去产生。
     * @param type
     * @return
     */
    public abstract Pizza createPizza(String type);
    
}
