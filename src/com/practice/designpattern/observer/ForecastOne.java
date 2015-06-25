package com.practice.designpattern.observer;

public class ForecastOne implements Observer, Display {
    private Long temperature;
    private Subject weatherData;
    
    public ForecastOne(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    
    @Override
    public void update(Long temperature, Long humidity, String weather) {
        // update!
        this.temperature = temperature;
        display();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("ForecastOne 我只显示温度: " + temperature);
    }

    public Long getTemperature() {
        return temperature;
    }

    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }
    
    public Subject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Subject weatherData) {
        this.weatherData = weatherData;
    }
    
    

}
