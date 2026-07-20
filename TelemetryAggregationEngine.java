import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelemetryAggregationEngine {

    public static void main(String[] args) {
        System.out.println("Initializing Advanced Telemetry Aggregation Hub...");
        System.out.println("---------------------------------------------------------");

        Map<String, Integer> serviceEventCounts = new HashMap<>();
        serviceEventCounts.put("auth-service", 142);

        int authEvents = serviceEventCounts.getOrDefault("auth-service", 0);

        int paymentEvents = serviceEventCounts.getOrDefault("payment-service", 0);

        System.out.println("Event Counts:");
        System.out.println(" -> auth-service   : " + authEvents);
        System.out.println(" -> payment-service: " + paymentEvents + " (Fallback default applied)");
        System.out.println("---------------------------------------------------------");


        Map<String, Integer> timeoutThresholds = new HashMap<>();

        timeoutThresholds.put("inventory-service", 5000);

        timeoutThresholds.putIfAbsent("inventory-service", 2000);
        timeoutThresholds.putIfAbsent("billing-service", 3000);

        System.out.println("Timeout Configuration Thresholds:");
        System.out.println(" -> inventory-service: " + timeoutThresholds.get("inventory-service") + " ms (Preserved override)");
        System.out.println(" -> billing-service  : " + timeoutThresholds.get("billing-service") + " ms (Default applied)");
        System.out.println("---------------------------------------------------------");


        Map<String, List<String>> alertGroups = new HashMap<>();

        alertGroups.computeIfAbsent("CRITICAL", key -> new ArrayList<>()).add("auth-service");
        alertGroups.computeIfAbsent("CRITICAL", key -> new ArrayList<>()).add("payment-service");
        alertGroups.computeIfAbsent("INFO", key -> new ArrayList<>()).add("analytics-service");

        System.out.println("Categorized Severity Alert Groups:");
        for (Map.Entry<String, List<String>> entry : alertGroups.entrySet()) {
            System.out.println(" -> Category [" + entry.getKey() + "]: " + entry.getValue());
        }
        System.out.println("---------------------------------------------------------");
    }
}