import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ServiceMetric {
    private final String serviceName;
    private final int responseTimeMs;
    private final boolean isHealthy;

    public ServiceMetric(String serviceName, int responseTimeMs, boolean isHealthy) {
        this.serviceName = serviceName;
        this.responseTimeMs = responseTimeMs;
        this.isHealthy = isHealthy;
    }

    public String getServiceName() {
        return serviceName;
    }

    public int getResponseTimeMs() {
        return responseTimeMs;
    }

    public boolean isHealthy() {
        return isHealthy;
    }
}

public class TelemetryStreamEngine {

    public static void main(String[] args) {
        System.out.println("Initializing Stream Processing Pipeline...");
        System.out.println("---------------------------------------------------------");

        List<ServiceMetric> metrics = new ArrayList<>();
        metrics.add(new ServiceMetric("auth-service", 120, true));
        metrics.add(new ServiceMetric("payment-service", 350, true));
        metrics.add(new ServiceMetric("billing-service", 80, false));
        metrics.add(new ServiceMetric("inventory-service", 95, true));
        metrics.add(new ServiceMetric("user-service", 180, true));

        List<String> highPerformingServices = metrics.stream()
                .filter(metric -> metric.isHealthy() && metric.getResponseTimeMs() <= 200)
                .map(metric -> metric.getServiceName().toUpperCase())
                .collect(Collectors.toList());

        System.out.println("High-Performing Active Services:");
        highPerformingServices.forEach(service -> System.out.println(" -> " + service));

        System.out.println("---------------------------------------------------------");
    }
}