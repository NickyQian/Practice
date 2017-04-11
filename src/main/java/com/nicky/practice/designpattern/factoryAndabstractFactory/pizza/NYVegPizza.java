package com.nicky.practice.designpattern.factoryAndabstractFactory.pizza;

import com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient.PizzaIngredientFactory;

/**
 * 纽约风味的蔬菜披萨
 * @author qianlei
 *
 */
public class NYVegPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    public NYVegPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        setName("New York Vegetables Pizza~~~");
    }
    @Override
    public void prepar() {
        // TODO Auto-generated method stub
        System.out.println(getName() + "\nPrepar Something......" + ingredientFactory.createIngredient());
    }

}
