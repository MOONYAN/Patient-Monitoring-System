package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileMeasureTest {

    @Test
    void measure() {
        IMeasure measure = new FileMeasure("BloodPressureData1.dataset");
        assertEquals(150.0, measure.measure());
        assertEquals(123.0, measure.measure());
        assertEquals(-1.0, measure.measure());
        assertEquals(200.0, measure.measure());
        assertEquals(-1.0, measure.measure());
    }

    @Test
    void fuckDouble() {
        String input = "150";
        Double number = Double.parseDouble(input);
        assertEquals(Double.valueOf(150.0), number);
    }
}