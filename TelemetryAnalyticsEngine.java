class NumericBuffer<T extends Number> {
    private final T primaryValue;
    private final T secondaryValue;

    public NumericBuffer(T primaryValue, T secondaryValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
    }

    public double calculateAverage() {
        double valueA = this.primaryValue.doubleValue();
        double valueB = this.secondaryValue.doubleValue();

        return (valueA + valueB) / 2.0;
    }
}

public class TelemetryAnalyticsEngine {

    public static void main(String[] args) {
        System.out.println("Activating Bounded Telemetry Processing Arrays...");
        System.out.println("---------------------------------------------------------");

        NumericBuffer<Integer> integerBuffer = new NumericBuffer<>(45, 90);
        System.out.println("Integer Metric Stream Average: " + integerBuffer.calculateAverage());

        System.out.println("---------------------------------------------------------");

        NumericBuffer<Double> doubleBuffer = new NumericBuffer<>(12.75, 44.50);
        System.out.println("Double Precision Stream Average: " + doubleBuffer.calculateAverage());

        System.out.println("---------------------------------------------------------");

    }
}