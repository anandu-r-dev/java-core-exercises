class TelemetryPacket {
    private final int packetId;
    private final long latencyMillis;

    public TelemetryPacket(int packetId, long latencyMillis) {
        this.packetId = packetId;
        this.latencyMillis = latencyMillis;
    }

    @Override
    public String toString() {
        return "TelemetryPacket [Packet ID: " + packetId + " | Latency: " + latencyMillis + " ms]";
    }
}

public class NetworkDiagnosticSuite {

    public static void main(String[] args) {
        System.out.println("Starting Network Diagnostics Print Tests...");
        System.out.println("---------------------------------------------------------");

        TelemetryPacket activePacket = new TelemetryPacket(505, 142L);

        System.out.println("Explicit toString() Call Output:");
        System.out.println(activePacket.toString());

        System.out.println("---------------------------------------------------------");

        System.out.println("Implicit Print Call Output:");
        System.out.println(activePacket);

        System.out.println("---------------------------------------------------------");
    }
}