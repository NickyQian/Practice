package com.nicky.practice.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    List<Observer> observers;
    private Long temperature;
    private Long humidity;
    private String weather;
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }
    /**
     * 注册观察者
     */
    @Override
    public void registerObserver(Observer ob) {
        observers.add(ob);
    }
    /**
     * 删除观察者
     */
    @Override
    public void removeObserver(Observer ob) {
        int i = observers.indexOf(ob);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    /**
     * 通知观察者
     */
    @Override
    public void notifyObservers() {
        for (Observer ob : observers) {
            ob.update(temperature, humidity, weather);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    };
    
    // 改变weather的数据
    public void setMeasurements(Long temperature, Long humidity, String weather) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.weather = weather;
        // 一但改变就通知数据发生变化
        measurementsChanged();
    }
    
    public Long getTemperature() {
        return temperature;
    }
    
    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }
    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
