package com.company;

import java.util.List;

public class StationMonitor implements IMonitor {
    private int _period;

    private List<Sensor> _sensors;

    public StationMonitor(int period) {
        _period = period;
    }

    public void setSensors(List<Sensor> sensors) {
        _sensors = sensors;
    }

    @Override
    public void display(String text) {
        System.out.println(text);
    }

    public void startMonitor() {
        for (int i = 0; i <= _period; i++) {
            for (Sensor sensor : _sensors) {
                sensor.acceptClock(i);
            }
        }
    }
}