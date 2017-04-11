package com.nicky.practice.designpattern.template;

public abstract class BaseCoffineDrink {

	/**
	 * 模板模式： 整一个准备过程规定好。 具体类通过实现具体的方法 从而获得不同的结果。 但是过程其实都一样
	 */
	public void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if (wantsCondiments()) {
			addCondiments();
		}
	}

	/**
	 * 实现默认的程序操作。 所有子类都用到此相同的方法。
	 */
	/* 煮开水 */
	public void boilWater() {
		System.out.println("boiling water......");
	}

	/* 冲泡 */
	public abstract void brew();

	/* 倒入杯子 */
	public void pourInCup() {
		System.out.println("Pouring into cup.");
	}

	/* 加调料 */
	public abstract void addCondiments();

	/**
	 * (hook) 用户默认需要调料 可在具体实现类中覆盖此方法
	 * 
	 * @return
	 */
	public boolean wantsCondiments() {
		return true;
	}
}
