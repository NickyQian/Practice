package com.nicky.practice.designpattern.state;
/**
 * 没有25分状态
 * @author Nicky
 *
 */
public class NoQuarterState implements State {
    private GumbalMachine gumbalMachine;
    public NoQuarterState(GumbalMachine gumbalMachine) {
        this.gumbalMachine = gumbalMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
        // 投了钱之后转入有25美分的状态
        gumbalMachine.setState(gumbalMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter.");
    }

    @Override
    public void turnCrank() {
        System.out.println("You truned, but there's no quarter.");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first.");
    }

}
