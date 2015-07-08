package com.practice.designpattern.factoryAndabstractFactory.pizzastore;

import java.util.stream.IntStream;


/**
 * 工厂方法模式：
 * 定义了一个创建对象的接口，但由子类
 * 决定要实例化的类是哪一个。工厂方法让类
 * 把实例化推迟到子类。
 * 
 * 抽象工厂模式：
 * 提供一个接口，用于创建相关或依赖
 * 对象的家庭，而不需要明确指定具体类
 *
 */
public class PizzaOrderDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NewYorkPizzaStore();
        nyPizzaStore.orderPizzza("cheese");
        IntStream.rangeClosed(0, 60).forEach((idx)->{
        	 System.out.print("=");
        });
        System.out.println();
        PizzaStore chPizzaStore = new ChicagoPizzaStore();
        chPizzaStore.orderPizzza("veg");
        
    }

}
