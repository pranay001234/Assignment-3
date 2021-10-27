package com.example.a612classweather;

public class Weather {
    private Temperature temperature;
    private String condition;
    private double windSpeed;

    //public  double humidity;

    //YAGNI -> You ain't gonna need it

    public void setTemperature(Temperature temp)
    {
        temperature = temp;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public String getCondition() { return condition; }

    public void setCondition(String cond) { condition = cond; }
}
