package com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient;

public class NewYorkIngredientFactory implements PizzaIngredientFactory {

    /**
     * 实现抽象工厂
     * 产生纽约的原料
     */
    @Override
    public String createIngredient() {
        // TODO Auto-generated method stub
        return "New York Fresh Ingredient";
    }

}
