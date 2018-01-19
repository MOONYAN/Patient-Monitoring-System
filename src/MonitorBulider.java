import java.util.ArrayList;
import java.util.List;

public class MonitorBulider {
    private IReader _reader;
    private IDatabase _database;

    public MonitorBulider(IReader reader, IDatabase database) {
        _reader = reader;
        _database = database;
    }

    public StationMonitor build() {
        StationMonitor monitor = null;
        List<String> lines = _reader.getLines();
        Patient patient = null;
        List<Sensor> sensors = new ArrayList<>();
        for (String line : lines) {
            String[] datas = line.split(" ");
            switch (datas.length) {
                case 1:
                    monitor = new StationMonitor(Integer.parseInt(datas[0]));
                    break;
                case 3:
                    patient = buildPatient(datas);
                    break;
                case 5:
                    Sensor sensor = buildSensor(datas);
                    sensor.setPatient(patient);
                    sensor.setDatabase(_database);
                    sensor.setMonitor(monitor);
                    sensors.add(sensor);
                    break;
                default:
                    System.err.println("build error!");
                    break;
            }
        }
        monitor.setSensors(sensors);
        return monitor;
    }

    private Patient buildPatient(String[] datas) {
        return new Patient(datas[1], Integer.parseInt(datas[2]));
    }

    private Sensor buildSensor(String[] datas) {
        Sensor sensor = null;
        switch (datas[0]) {
            case "BloodPressureSensor":
                sensor = new BloodPressureSensor(datas[1], Double.parseDouble(datas[3]), Double.parseDouble(datas[4]), new FileMeasure(datas[2]));
                break;
            case "PulseSensor":
                sensor = new PulseSensor(datas[1], Double.parseDouble(datas[3]), Double.parseDouble(datas[4]), new FileMeasure(datas[2]));
                break;
            case "TemperatureSensor":
                sensor = new TemperatureSensor(datas[1], Double.parseDouble(datas[3]), Double.parseDouble(datas[4]), new FileMeasure(datas[2]));
                break;
            default:
                System.err.println("build sensor error!");
                break;
        }
        return sensor;
    }
}