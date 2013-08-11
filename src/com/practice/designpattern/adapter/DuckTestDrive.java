package com.practice.designpattern.adapter;

/**
 * @author qianlei
 * 
 */
public class DuckTestDrive {

    public static void main(String[] args) {
        /* 定义一只火鸡 */
        Turkey wildTurkey = new WildTurkey();
        /* 需要一只鸭子，通过火鸡适配器转换 */
        Duck duck = new TurkeyAdapter(wildTurkey);

        duck.fly();
        duck.quack();
    }

}
