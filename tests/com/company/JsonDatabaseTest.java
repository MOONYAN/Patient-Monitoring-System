package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonDatabaseTest {

    @Test
    void display() {
        IDatabase database = new JsonDatabase();
        Patient patient = new Patient("Mark", 600);
        Sensor sensor = new BloodPressureSensor("sensor1", 150, 200, null);
        database.store(patient,sensor,0,150);
        database.store(patient,sensor,600,123);

        List<String> triggers = new ArrayList<>();
        database.display(new IMonitor() {
            @Override
            public void display(String text) {
                triggers.add(text);
            }
        });
        assertEquals(4,triggers.size());
        assertEquals("patient Mark", triggers.get(0));
        assertEquals("BloodPressureSensor sensor1", triggers.get(1));
        assertEquals("[0] 150.0", triggers.get(2));
        assertEquals("[600] 123.0", triggers.get(3));
    }
}