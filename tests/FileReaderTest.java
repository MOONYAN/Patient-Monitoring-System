
import org.junit.jupiter.api.Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void getLines() {
        String file = "BloodPressureData1.dataset";
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(file), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    @Test
    void getDataset() {
        IReader reader = new FileReader("BloodPressureData1.dataset");
        List<String> lines = reader.getLines();
        assertEquals(5, lines.size());
        assertEquals("150", lines.get(0));
        assertEquals("123", lines.get(1));
        assertEquals("-1", lines.get(2));
        assertEquals("200", lines.get(3));
        assertEquals("-1", lines.get(4));
    }

    @Test
    void getSampleInput() {
        IReader reader = new FileReader("SampleInput");
        List<String> lines = reader.getLines();
        assertEquals(5, lines.size());
        assertEquals("3000", lines.get(0));
        assertEquals("patient Mark 600", lines.get(1));
        assertEquals("BloodPressureSensor sensor1 BloodPressureData1.dataset 150 200", lines.get(2));
        assertEquals("patient Tony 500", lines.get(3));
        assertEquals("BloodPressureSensor sensor2 BloodPressureData1.dataset 130 150", lines.get(4));
    }
}