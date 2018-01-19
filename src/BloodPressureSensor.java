public class BloodPressureSensor extends Sensor {


    public BloodPressureSensor(String name, double lowerBound, double upperBound, IMeasure measure) {
        super(name, lowerBound, upperBound, measure);
    }

    @Override
    public String getCategory() {
        return "BloodPressureSensor";
    }
}