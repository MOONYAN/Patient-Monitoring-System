
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SensorTest {
    @Test
    public void constructor() {
        Sensor sensor = new BloodPressureSensor("blood sensor", 150, 200, null);
        assertEquals("BloodPressureSensor", sensor.getCategory());
    }

    @Test()
    void acceptClock() {
        List<String> alarms = new ArrayList<>();
        Sensor sensor = new BloodPressureSensor("sensor1", 150, 200, new MockMeasure());
        sensor.setPatient(new Patient("Mark", 600));
        sensor.setMonitor(new IMonitor() {
            @Override
            public void display(String text) {
                alarms.add(text);
            }
        });
        for (int i = 0; i <= 3000; i++) {
            sensor.acceptClock(i);
        }
        assertEquals(4,alarms.size());
        assertEquals("[600] Mark is in danger! Cause: sensor1 123.0", alarms.get(0));
        assertEquals("[1200] sensor1 falls", alarms.get(1));
        assertEquals("[2400] sensor1 falls", alarms.get(2));
        assertEquals("[3000] sensor1 falls", alarms.get(3));
    }
}