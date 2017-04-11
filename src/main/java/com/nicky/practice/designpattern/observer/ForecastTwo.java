package com.nicky.practice.designpattern.observer;

public class ForecastTwo implements Observer, Display{
    private WeatherData weatherData;
    private Long humidity;
    public ForecastTwo(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(Long temp, Long humidity, String weather) {
        this.humidity = humidity;
        display();
    }
    @Override
    public void display() {
        System.out.println("ForecastTwo 我只需要湿度： " + humidity);
        
    }
    
    public WeatherData getWeatherData() {
        return weatherData;
    }
    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
    public Long getHumidity() {
        return humidity;
    }
    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }
    
}
