package com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient;

public class ChicagoIngredientFactory implements PizzaIngredientFactory {
    /**
     * 实现抽象方法
     * 产生芝加哥的原料
     */
    @Override
    public String createIngredient() {
        // TODO Auto-generated method stub
        return "Chicago Freezed Ingredient";
    }

}
