package com.nicky.practice.designpattern.state;
/**
 * 抽象的状态接口
 * 拥有4种动作
 * @author Nicky
 *
 */
public interface State {
    // 投入25美分
    public void insertQuarter();
    // 退回25美分
    public void ejectQuarter();
    // 转动曲柄
    public void turnCrank();
    // 发放糖果
    public void dispense();
}
