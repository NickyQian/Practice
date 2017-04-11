package com.nicky.practice.designpattern.observer.javaObserver;

import java.util.Observable;
import java.util.Observer;

public class TemperatureForecast implements Observer {

	public TemperatureForecast(WeatherDataUsingJavaUtil weatherData) {
		weatherData.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		WeatherDataUsingJavaUtil weather = (WeatherDataUsingJavaUtil) o;
		System.out.println("========================");
		System.out.println("Temperature Forecast: " + weather.getTemperature());
		System.out.println("Notice: " + arg);
	}

}
