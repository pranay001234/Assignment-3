package com.example.a612classweather;

public interface WeatherApi {
    void getWeatherForZipCode(String zipCode, Callback callback);
}
