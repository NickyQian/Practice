package com.practice.designpattern.state;
/**
 * 有25美分状态
 * @author Nicky
 *
 */
public class HasQuarterState implements State {
    // 每个状态包含一个 糖果机实例 用来更新它的状态
    private GumbalMachine gumbalMachine;
    
    public HasQuarterState(GumbalMachine gumbalMachine) {
        this.gumbalMachine = gumbalMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned.");
        // 动作执行完后 转到新的状态
        gumbalMachine.setState(gumbalMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumbalMachine.setState(gumbalMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed.");
    }

}
