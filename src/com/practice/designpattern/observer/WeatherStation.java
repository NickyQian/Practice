package com.practice.designpattern.observer;

public class WeatherStation {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(1L);
        ForecastOne forecast1 = new ForecastOne(weatherData);

        weatherData.setMeasurements(2L, 0L, "rain");
        weatherData.setMeasurements(3L, 0L, "sun");
     }
}
