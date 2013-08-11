package com.practice.designpattern.composite;

/**
 * 组合模式： 允许你将对象组合成树形结构 来表现“整体/部分”层次结构。 组合能让客户以一致的方式处 理个别对象以及对象数组
 * 
 * @author qianlei
 * 
 */
public class TestDrive {

    public static void main(String[] args) {
        MenuComponent breakfastMenu = new Menu("BREAKFAST MENU",
                "Nice Breakfast");
        MenuComponent dinnerMenu = new Menu("DINNER MENU", "Nice Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Nice Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Nice Dessert");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(breakfastMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);

        // 在这里加入菜单项
        dinnerMenu.add(new MenuItem("Pasta", "%this is discription of Pasta%",
                true, 3.89));
        // 加入甜品的子菜单
        dinnerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("Apple pie",
                "%this is discription of apple pie%", true, 1.59));
        /**
         * 一旦我们将整个菜单层次构造完毕， 把它整个交给招待员 直接调用打印方法即可。
         */
        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();

    }

}
