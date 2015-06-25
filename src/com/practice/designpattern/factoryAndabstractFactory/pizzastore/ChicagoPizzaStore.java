package com.practice.designpattern.factoryAndabstractFactory.pizzastore;

import com.practice.designpattern.factoryAndabstractFactory.ingredient.ChicagoIngredientFactory;
import com.practice.designpattern.factoryAndabstractFactory.ingredient.PizzaIngredientFactory;
import com.practice.designpattern.factoryAndabstractFactory.pizza.ChicagoCheesePizza;
import com.practice.designpattern.factoryAndabstractFactory.pizza.ChicagoVegPizza;
import com.practice.designpattern.factoryAndabstractFactory.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {
	/* 芝加哥披萨店都是使用芝加哥的原料 */
	private PizzaIngredientFactory ingredientFactory = new ChicagoIngredientFactory();

	/**
	 * 芝加哥店 只做芝加哥风味的各种披萨
	 */
	@Override
	public Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new ChicagoCheesePizza(ingredientFactory);
		} else if (type.equals("veg")) {
			return new ChicagoVegPizza(ingredientFactory);
		} else {
			return null;
		}
	}

}
