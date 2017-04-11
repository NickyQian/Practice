package com.nicky.practice.designpattern.command.homeapplications;
/**
 * 家电 ： 灯
 * @author qianlei
 *
 */
public class Light {
    private String lightName;
    
    public Light(String name) {
        lightName = name;
    }
    public void on() {
        System.out.println("Light, "+ lightName + ", is on.");
    }
    
    public void off() {
        System.out.println("Light, "+ lightName + ", is off.");
    }
    
    public String getLightName() {
        return lightName;
    }
    public void setLightName(String lightName) {
        this.lightName = lightName;
    }
    
}
