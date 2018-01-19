abstract public class Sensor {

    private String _name;
    private double _lowerBound;
    private double _upperBound;
    private IMeasure _measure;
    private IMonitor _monitor;
    private IDatabase _database;
    private Patient _patient;

    public Sensor(String name, double lowerBound, double upperBound, IMeasure measure) {
        _name = name;
        _lowerBound = lowerBound;
        _upperBound = upperBound;
        _measure = measure;
    }

    public void acceptClock(int clock) {
        if (_patient.isOnClock(clock)) {
            trigger(clock);
        }
    }

    private void trigger(int clock) {
        double factor = _measure.measure();
        if (_database != null) {
            _database.store(_patient, this, clock, factor);
        }
        if (_monitor != null) {
            if (factor == -1) {
                _monitor.display(String.format("[%d] %s falls", clock, _name));
            } else if (factor < _lowerBound || factor > _upperBound) {
                _monitor.display(String.format("[%d] %s is in danger! Cause: %s %.1f", clock, _patient.getName(), _name, factor));
            }
        }
    }

    abstract public String getCategory();

    public void setPatient(Patient patient) {
        _patient = patient;
    }

    public void setMonitor(IMonitor monitor) {
        _monitor = monitor;
    }

    public void setDatabase(IDatabase database) {
        _database = database;
    }

    public String getName() {
        return _name;
    }
}
