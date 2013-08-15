package com.practice.designpattern.state;
/**
 * 出售状态
 * 
 * @author Nicky
 * 
 */
public class SoldState implements State {
    private GumbalMachine gumbalMachine;
    public SoldState(GumbalMachine gumbalMachine) {
        this.gumbalMachine = gumbalMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("Please wait. we're already giving you a gumball.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball.");
    }

    @Override
    public void dispense() {
        gumbalMachine.realeasBall();
        if (gumbalMachine.getCount() > 0) {
            gumbalMachine.setState(gumbalMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs.");
            gumbalMachine.setState(gumbalMachine.getSoldOutState());
        }
    }
}
