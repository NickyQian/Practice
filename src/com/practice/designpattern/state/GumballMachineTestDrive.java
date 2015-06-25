package com.practice.designpattern.state;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumbalMachine machine = new GumbalMachine(5);
        
        machine.insertQuarter();
        machine.turnCrank();

        machine.insertQuarter();
        machine.ejectQuarter();
    }
}
