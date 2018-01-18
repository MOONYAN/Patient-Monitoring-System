package com.company;

public class PulseSensor extends Sensor {
    public PulseSensor(String name, double lowerBound, double upperBound, IMeasure measure) {
        super(name, lowerBound, upperBound, measure);
    }

    @Override
    public String getCategory() {
        return "PulseSensor";
    }
}