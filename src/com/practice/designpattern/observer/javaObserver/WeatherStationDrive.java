package com.practice.designpattern.observer.javaObserver;

import org.junit.Test;

public class WeatherStationDrive {

	@Test
	public void test() {
		WeatherDataUsingJavaUtil weather = new WeatherDataUsingJavaUtil();
		weather.setHumidity(1L);
		weather.setTemperature(30L);

		HumidityForecast forecastHumidity = new HumidityForecast(weather);
		TemperatureForecast forecastTemperature = new TemperatureForecast(weather);
		weather.setHumidity(2L);
		
		weather.setTemperature(60L);
		
		weather.deleteObserver(forecastHumidity);
		weather.setTemperature(90L);
		weather.setTemperature(90L);

		weather.deleteObserver(forecastTemperature);
	}
}
