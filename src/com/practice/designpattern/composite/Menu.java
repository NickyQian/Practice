package com.practice.designpattern.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 实现组合菜单
 * 
 * @author qianlei
 * 
 */
public class Menu extends MenuComponent {
    /*
     * 菜单可以有任意数目的子菜单，这些 子菜单都必须属于MenuComponent类型， 我们使用内部的ArrayList记录它们
     */
    ArrayList<MenuComponent> menuCompnents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuCompnents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuCompnents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuCompnents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("-------------------------------------");

        /**
         * 遍历拥有的菜单项 或者 子菜单 一并打印
         */
        Iterator<MenuComponent> iterator = menuCompnents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            menuComponent.print();
        }
    }
}
