package com.nicky.practice.designpattern.observer.javaObserver;

import java.util.Observable;

public class WeatherDataUsingJavaUtil extends Observable {
	private Long temperature;
	private Long humidity;

	public Long getTemperature() {
		return temperature;
	}

	public void setTemperature(Long temperature) {
		if (!temperature.equals(temperature)) {
			this.temperature = temperature;
			setChanged();
			notifyObservers("This is from Weather Data using Java Util. Temperature Changed Only.");
		}
	}

	public Long getHumidity() {
		return humidity;
	}

	public void setHumidity(Long humidity) {
		if (!humidity.equals(humidity)) {
			this.humidity = humidity;
			setChanged();
			notifyObservers("This is from Weather Data using Java Util. Humidity Changed Only.");
		}
	}

}
