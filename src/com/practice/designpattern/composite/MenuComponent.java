package com.practice.designpattern.composite;
/**
 * 所有的组件都必须实现MenuComponent接口；
 * 然而，叶子节点和组合节点的角色不同，所以有些方法
 * 可能并不适用某种节点。面对这种情况，有时候，你最好
 * 抛出运行时异常。
 * @author qianlei
 *
 */
public abstract class MenuComponent {

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    
    public void print() {
        throw new UnsupportedOperationException();
    }
}
