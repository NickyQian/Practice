package com.practice.designpattern.state;
/**
 * 售罄状态
 * @author Nicky
 *
 */
@SuppressWarnings("unused")
public class SoldOutState implements State {
    private GumbalMachine gumbalMachine;
    
    public SoldOutState(GumbalMachine gumbalMachine) {
        this.gumbalMachine = gumbalMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("Oops, out of gumballs.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Oops, out of gumballs.");
    }

    @Override
    public void turnCrank() {
        System.out.println("Oops, out of gumballs.");
    }

    @Override
    public void dispense() {
        System.out.println("Oops, out of gumballs.");
    }

}
