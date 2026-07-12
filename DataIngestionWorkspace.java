import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class DataIngestionWorkspace {

    public static void main(String[] args) {
        System.out.println("Booting Java Built-in Functional Interface Pipeline...");
        System.out.println("---------------------------------------------------------");

        Supplier<String> defaultTokenSupplier = () -> "FALLBACK-LOG-000";

        System.out.println("Executing Supplier Demo:");
        System.out.println(" Generated Value: " + defaultTokenSupplier.get());
        System.out.println("---------------------------------------------------------");

        Function<String, Integer> stringParser = (rawInput) -> Integer.parseInt(rawInput.trim());

        Predicate<Integer> highLoadThreshold = (measuredValue) -> measuredValue > 50;

        Consumer<Integer> consoleLogger = (finalMetric) -> System.out.println(" [ALERT LOGGER] -> Outlier detected: Metric value stands at " + finalMetric);

        String[] telemetryStream = {"14", "87", "32", "109"};

        System.out.println("Processing Active Telemetry Stream Array:");
        for (String rawData : telemetryStream) {
            Integer parsedValue = stringParser.apply(rawData);

            if (highLoadThreshold.test(parsedValue)) {
                consoleLogger.accept(parsedValue);
            } else {
                System.out.println(" [System Core]  -> Metric " + parsedValue + " falls inside safe parameters.");
            }
        }
        System.out.println("---------------------------------------------------------");
    }
}