package com.company;

public interface IDatabase {
    void store(Patient patient, Sensor sensor, int clock, double factor);
}