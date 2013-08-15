package com.practice.designpattern.iterator;
/**
 * 迭代器模式：
 * 提供一种方法顺序访问一个聚合对象中的
 * 各个元素，而又不暴露其内部的表示。
 * @author qianlei
 *
 */
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;
    
    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}
