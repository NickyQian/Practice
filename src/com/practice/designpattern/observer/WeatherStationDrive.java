package com.practice.designpattern.observer;
/**
 * 观察者模式：
 * 定义了对象之间的一对多依赖，
 * 这样一来，当一个对象改变状态时，
 * 它的所有依赖者都会收到通知并更新
 * @author qianlei
 *
 */
public class WeatherStationDrive {
    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(1L);
        ForecastOne forecast1 = new ForecastOne(weatherData);
        ForecastTwo forecast2 = new ForecastTwo(weatherData);
        weatherData.setMeasurements(2L, 234L, "rain");
        weatherData.setMeasurements(3L, 567L, "sun");
        System.out.println("========================= remove observers one===================");
        // 从注册队列中删除
        Subject subject = forecast1.getWeatherData();
        subject.removeObserver(forecast1);
        weatherData.setMeasurements(2L, 8910L, "windy");
        System.out.println("========================= remove observers two===================");
        subject.removeObserver(forecast2);
        weatherData.setMeasurements(2L, 8910L, "windy");
        System.out.println("========================= add observers again===================");
        subject.registerObserver(forecast1);
        subject.registerObserver(forecast2);
        weatherData.setMeasurements(2L, 8910L, "windy");
     }
}
