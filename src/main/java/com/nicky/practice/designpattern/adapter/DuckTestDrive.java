package com.nicky.practice.designpattern.adapter;

/**
 * 适配器模式 将一个类的接口 转换成客户期望的另一个接口。 适配器让原本接口不兼容的类可以合作无间。
 * 
 * @author qianlei
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
