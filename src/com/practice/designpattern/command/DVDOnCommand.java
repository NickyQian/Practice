package com.practice.designpattern.command;

import com.practice.designpattern.command.homeapplications.DVDPlayer;

public class DVDOnCommand implements Command {
    private DVDPlayer dvdPlayer;
    
    public DVDOnCommand(DVDPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }
    @Override
    public void execute() {
        dvdPlayer.watchMovie();
    }
    @Override
    public void undo() {
        dvdPlayer.watchMovie();
    }
    
}
