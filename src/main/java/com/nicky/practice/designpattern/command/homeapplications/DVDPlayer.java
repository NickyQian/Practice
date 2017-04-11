package com.nicky.practice.designpattern.command.homeapplications;

public class DVDPlayer {
    private String name;
    
    public DVDPlayer(String name) {
        this.name = name;
    }
    
    public void putDVD() {
        System.out.println("Put DVD......");
    }
    public void playDVD() {
        System.out.println("Play DVD......");
    }
    
    public void watchMovie() {
        System.out.println("DVD, "+ name +", begins to play.");
        putDVD();
        playDVD();
    }
    
    public void closeDVD() {
        System.out.println("DVD, "+ name +", is closed.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
