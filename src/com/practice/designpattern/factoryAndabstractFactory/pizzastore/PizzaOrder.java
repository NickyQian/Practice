package com.practice.designpattern.factoryAndabstractFactory.pizzastore;

public class PizzaOrder {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NewYorkPizzaStore();
        nyPizzaStore.orderPizzza("cheese");
        
        for (int i = 0; i<60;i++) {
            System.out.print("=");
        }
        
        System.out.println();
        PizzaStore chPizzaStore = new ChicagoPizzaStore();
        chPizzaStore.orderPizzza("veg");
        
    }

}
