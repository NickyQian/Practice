package com.practice.designpattern.command;

import com.practice.designpattern.command.homeapplications.DVDPlayer;

public class DVDOffCommand implements Command {
    private DVDPlayer dvdPlayer;
    
    public DVDOffCommand(DVDPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }
    
    @Override
    public void execute(){
        dvdPlayer.closeDVD();
    }

    @Override
    public void undo() {
        dvdPlayer.watchMovie();
    }
    
}
