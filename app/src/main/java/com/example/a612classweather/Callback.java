package com.example.a612classweather;

public interface Callback {
    void success(Weather currentWeather);
    void error(ErrorType error);

}

