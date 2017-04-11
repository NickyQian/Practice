package com.nicky.practice.designpattern.command;

import com.nicky.practice.designpattern.command.homeapplications.Light;

public class LightOnCommand implements Command {
    private Light light;
    
    public LightOnCommand(Light light) {
        this.light = light;
    }
    
    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
