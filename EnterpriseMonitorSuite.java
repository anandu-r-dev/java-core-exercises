interface TelemetryNode {
    String PROTOCOL_VERSION = "V2.1";

    String transmitTelemetry();
}

class ProductionLine implements TelemetryNode {
    private final String stationName;
    private final double efficiencyScore;

    public ProductionLine(String stationName, double efficiencyScore) {
        this.stationName = stationName;
        this.efficiencyScore = efficiencyScore;
    }

    @Override
    public String transmitTelemetry() {
        return "[" + PROTOCOL_VERSION + "] Station: " + stationName +
                " | Operational Efficiency: " + efficiencyScore + "%";
    }
}

public class EnterpriseMonitorSuite {

    public static void main(String[] args) {
        System.out.println("Initializing Enterprise Telemetry Stream...");
        System.out.println("---------------------------------------------------------");

        TelemetryNode activeStream = new ProductionLine("Assembly-Line-Delta", 94.2);

        String standardPayload = activeStream.transmitTelemetry();

        System.out.println("Incoming Diagnostics Stream Buffer:");
        System.out.println(standardPayload);

        System.out.println("---------------------------------------------------------");
    }
}