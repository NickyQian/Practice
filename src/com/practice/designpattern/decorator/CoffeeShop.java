package com.practice.designpattern.decorator;

public class CoffeeShop {
    
    public static void main(String[] args) {
        // 先来一杯深度烘焙咖啡
        DarkRoast darkRoast = new DarkRoast();
        System.out.println("Description: " + darkRoast.getDescription());
        System.out.println("一杯深度烘焙咖啡的价格 ： " + darkRoast.cost() +" 美元。");
        // 加点奶
        MilkDecorator milkDecorator = new MilkDecorator(darkRoast);
        System.out.println("Description: " + milkDecorator.getDescription());
        System.out.println("一杯加奶的深度烘焙咖啡的价格 ： " + milkDecorator.cost() +" 美元。");
        // 做成摩卡
        MochaDecorator mocha = new MochaDecorator(milkDecorator);
        System.out.println("Description: " + mocha.getDescription());
        System.out.println("一杯加奶的摩卡深度烘焙咖啡的价格 ： " + mocha.cost() +" 美元。");
        
        for (int i = 0; i<60;i++) {
            System.out.print("=");
        }
        System.out.println();
        
        Espresso espresso = new Espresso();
        System.out.println("Description: " + espresso.getDescription());
        System.out.println("一杯速溶咖啡的价格 ： " + espresso.cost() +" 美元。");
        // 加点奶
        MilkDecorator milkEspresso = new MilkDecorator(espresso);
        System.out.println("Description: " + milkEspresso.getDescription());
        System.out.println("一杯加奶的速溶咖啡的价格 ： " + milkEspresso.cost() +" 美元。");
        // 做成摩卡
        MochaDecorator mochaEspresso = new MochaDecorator(milkEspresso);
        System.out.println("Description: " + mochaEspresso.getDescription());
        System.out.println("一杯加奶的摩卡速溶咖啡的价格 ： " + mochaEspresso.cost() +" 美元。");
    }

}
