package com.practice.java8.defaultinterface;

public interface FormulaInterface {
    default String sqrt(long a) {
        return "";
    }
}
// 多继承 如果两个接口的default方法签名一样，则实现会出错。
class Impl implements FormulaInterface,Formula{
    
    @Override
    public double calculate(int a) {
        // TODO Auto-generated method stub
        return 0;
    }
  }
