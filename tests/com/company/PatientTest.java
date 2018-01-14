package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void constructor() {
        Patient patient = new Patient("Mark", 3000);
        assertEquals("Mark", patient.getName());
        assertEquals(3000, patient.getPeriod());
    }
}