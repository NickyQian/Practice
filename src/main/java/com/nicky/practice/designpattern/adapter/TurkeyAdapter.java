package com.nicky.practice.designpattern.adapter;

/**
 * 适配器 将火鸡适配成鸭子 *
 * 适配器模式：
 * 将一个类的接口，转换成客户期望的另一个接口。
 * 适配器让原本不兼容的类可以使用。
 * @author qianlei
 * 
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void fly() {
        for (int i = 0; i < 3; i++) {
            turkey.fly(); // 火鸡飞的短，设置多飞几下
        }
    }

    @Override
    public void quack() {
        turkey.gobble(); // 把火鸡的咯咯叫 转成鸭子适用的呱呱叫方法
    }

}
