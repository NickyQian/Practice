package com.nicky.practice.designpattern.factoryAndabstractFactory.pizzastore;

import com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient.NewYorkIngredientFactory;
import com.nicky.practice.designpattern.factoryAndabstractFactory.ingredient.PizzaIngredientFactory;
import com.nicky.practice.designpattern.factoryAndabstractFactory.pizza.NYCheesePizza;
import com.nicky.practice.designpattern.factoryAndabstractFactory.pizza.NYVegPizza;
import com.nicky.practice.designpattern.factoryAndabstractFactory.pizza.Pizza;

public class NewYorkPizzaStore extends PizzaStore {
    /*纽约披萨店都是使用纽约的原料 */
    private PizzaIngredientFactory ingredientFactory = new NewYorkIngredientFactory();
    /**
     * 实现了工厂方法接口，并制造对象
     * 纽约店 只做纽约风味的各种披萨
     */
    @Override
    public Pizza createPizza(String type) {
        // TODO Auto-generated method stub
        if (type.equals("cheese")) {
            return new NYCheesePizza(ingredientFactory);
        }
        else if (type.equals("veg")) {
            return new NYVegPizza(ingredientFactory);
        } else {
            return null;
        }
    }
}
