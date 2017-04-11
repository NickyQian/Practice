package com.nicky.practice.designpattern.factoryAndabstractFactory.pizza;

import com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient.PizzaIngredientFactory;

/**
 * 芝加哥风味的蔬菜皮塞
 * @author qianlei
 *
 */
public class ChicagoVegPizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    public ChicagoVegPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        setName("Chicago Vegetables Pizza~~~");
    }
    @Override
    public void prepar() {
        // TODO Auto-generated method stub
        System.out.println(getName() + "\nPrepar Something......" + ingredientFactory.createIngredient());
    }

}
