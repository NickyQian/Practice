package com.nicky.practice.designpattern.observer.javaObserver;

import java.util.Observable;
import java.util.Observer;

public class HumidityForecast implements Observer {

	public HumidityForecast(WeatherDataUsingJavaUtil weatherData) {
		weatherData.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		WeatherDataUsingJavaUtil weather = (WeatherDataUsingJavaUtil) o;
		System.out.println("========================");
		System.out.println("Humidity Forecast: " + weather.getHumidity());
		System.out.println("Notice: " + arg);
	}

}
