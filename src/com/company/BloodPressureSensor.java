package com.company;

public class BloodPressureSensor extends Sensor {

    public BloodPressureSensor(String name, double upperBound, double lowerBound, IMeasure measure) {
        super(name, upperBound, lowerBound, measure);
    }

    @Override
    public String getCategory() {
        return "BloodPressureSensor";
    }
}
