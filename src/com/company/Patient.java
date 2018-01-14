package com.company;

public class Patient {
    private String _name;
    private int _period;

    public Patient(String name, int period) {
        _name = name;
        _period = period;
    }

    public int getPeriod() {
        return _period;
    }

    public String getName() {
        return _name;
    }
}
