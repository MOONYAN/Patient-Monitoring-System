
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonitorBuliderTest {

    @Test
    void testSplit() {
        String str = "patient Mark 600";
        String[] datas = str.split(" ");
        assertEquals(3, datas.length);
        assertEquals("patient", datas[0]);
        assertEquals("Mark", datas[1]);
        assertEquals("600", datas[2]);
        assertTrue(datas[0].equals("patient"));
    }

    @Test
    void build() {
        MonitorBulider bulider = new MonitorBulider(new FileReader("SampleInput"), new JsonDatabase());
        StationMonitor monitor = bulider.build();
        monitor.startMonitor();
    }
}