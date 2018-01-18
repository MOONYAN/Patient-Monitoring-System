package com.company;

public class TemperatureSensor extends Sensor {
    public TemperatureSensor(String name, double lowerBound, double upperBound, IMeasure measure) {
        super(name, lowerBound, upperBound, measure);
    }

    @Override
    public String getCategory()  {
        return "PulseSensor";
    }
}