package com.practice.designpattern.command;

public class NoCommand implements Command {

    @Override
    public void execute() {
        System.out.println("You have't set any commands here.");
    }

    @Override
    public void undo() {
        System.out.println("Nothing to undo...");
    }

}
