package com.nicky.practice.designpattern.command;

import com.nicky.practice.designpattern.command.homeapplications.Light;

public class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }
    @Override
    public void undo() {
        light.on();
    }

}
