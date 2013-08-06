package com.practice.designpattern.factoryAndabstractFactory.pizza;

import com.practice.designpattern.factoryAndabstractFactory.ingredient.PizzaIngredientFactory;

/**
 * 芝加哥风味的芝士披萨
 * @author qianlei
 *
 */
public class ChicagoCheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    public ChicagoCheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        setName("Chicago Cheese Pizza~~~");
    }
    @Override
    public void prepar() {
        // TODO Auto-generated method stub
        System.out.println(getName() + "\nPrepar Something......" + ingredientFactory.createIngredient());
    }

}
