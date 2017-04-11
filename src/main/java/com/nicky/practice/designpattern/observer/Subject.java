package com.nicky.practice.designpattern.observer;

public interface Subject {
//    List<Observer> observers;
    public void registerObserver(Observer ob);
    public void removeObserver(Observer ob);
    public void notifyObservers();
}
