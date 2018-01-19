import org.json.*;

public class JsonDatabase implements IDatabase {

    private JSONObject _patients;

    public JsonDatabase() {
        _patients = new JSONObject();
    }

    @Override
    public void store(Patient patient, Sensor sensor, int clock, double factor) {
        JSONObject p = getPatient(_patients, patient);
        JSONObject s = getSensor(p, sensor);
        JSONArray triggers = s.getJSONArray("Triggers");
        triggers.put(String.format("[%d] %.1f", clock, factor));
    }

    @Override
    public void display(IMonitor monitor) {
        for (String patientKey : _patients.keySet()) {
            JSONObject patient = _patients.getJSONObject(patientKey);
            monitor.display(String.format("patient %s", patientKey));
            for (String sensorKey : patient.keySet()) {
                JSONObject sensor = patient.getJSONObject(sensorKey);
                monitor.display(String.format("%s %s", sensor.getString("Category"), sensorKey));
                sensor.getJSONArray("Triggers").forEach((trigger) -> {
                    monitor.display(trigger.toString());
                });
            }
        }
    }

    private JSONObject getPatient(JSONObject root, Patient patient) {
        JSONObject goal;
        if (root.isNull(patient.getName())) {
            goal = new JSONObject();
            root.put(patient.getName(), goal);
        } else {
            goal = root.getJSONObject(patient.getName());
        }
        return goal;
    }

    private JSONObject getSensor(JSONObject root, Sensor sensor) {
        JSONObject goal;
        if (root.isNull(sensor.getName())) {
            goal = new JSONObject();
            goal.put("Name", sensor.getName());
            goal.put("Category", sensor.getCategory());
            goal.put("Triggers", new JSONArray());
            root.put(sensor.getName(), goal);
        } else {
            goal = root.getJSONObject(sensor.getName());
        }
        return goal;
    }
}