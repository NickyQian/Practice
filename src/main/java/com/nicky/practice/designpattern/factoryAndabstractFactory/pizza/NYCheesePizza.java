package com.nicky.practice.designpattern.factoryAndabstractFactory.pizza;

import com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient.PizzaIngredientFactory;

/**
 * 纽约风味的芝士披萨
 * @author qianlei
 *
 */
public class NYCheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    public NYCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        setName("New York Cheese Pizza~~~");
    }
    @Override
    public void prepar() {
        // TODO Auto-generated method stub
        System.out.println(getName() + "\nPrepar Something......" + ingredientFactory.createIngredient());
    }
}
