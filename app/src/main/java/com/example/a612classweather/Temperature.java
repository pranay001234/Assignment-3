package com.example.a612classweather;

public class Temperature {

    private double temperature;
    private TemperatureScale baseScale;

    public Temperature () {

    }

    public Temperature (double temp, TemperatureScale scale)
    {
        temperature = temp;
        baseScale = scale;
    }

    public double convert(TemperatureScale desiredScale) {
        if (baseScale == TemperatureScale.KELVIN &&
                desiredScale == TemperatureScale.CELSIU) {
            return temperature - 273;
        } else if (baseScale == TemperatureScale.KELVIN &&
                desiredScale == TemperatureScale.FEHRENHEIT) {
            //(0K − 273.15) × 9/5 + 32
            return (temperature - 273) * 9 / 5 + 32;
        } else if (baseScale == TemperatureScale.FEHRENHEIT &&
                desiredScale == TemperatureScale.CELSIU) {

        } else if (baseScale == TemperatureScale.CELSIU &&
                desiredScale == TemperatureScale.FEHRENHEIT) {
        }
        return temperature;

    }






    public void setTemperature(double temp, TemperatureScale scale)
    {
        baseScale = scale;
        temperature = temp;
    }

}

