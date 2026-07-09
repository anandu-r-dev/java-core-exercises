class DataHub {
    private final String hubName;
    private static final String FIRMWARE_TAG = "REV-2026.4";

    public DataHub(String hubName) {
        this.hubName = hubName;
    }

    class InternalSensor {
        private final int sensorId;

        public InternalSensor(int sensorId) {
            this.sensorId = sensorId;
        }

        public void printState() {
            System.out.println("InternalSensor -> Active ID: " + sensorId);
            System.out.println("  Linked to Enclosing Parent: " + hubName);
        }
    }

    static class DiagnosticTool {
        public void runningHardwareScan() {
            System.out.println("DiagnosticTool -> Running isolated network sweep...");
            System.out.println("  Evaluating System Firmware: " + FIRMWARE_TAG);

        }
    }
}

public class TelemetryController {

    public static void main(String[] args) {
        System.out.println("Booting Nested Component Architecture System...");
        System.out.println("---------------------------------------------------------");

        DataHub.DiagnosticTool tool = new DataHub.DiagnosticTool();
        tool.runningHardwareScan();

        System.out.println("---------------------------------------------------------");

        DataHub primaryHub = new DataHub("Alpha-Core-Station");

        DataHub.InternalSensor sensor = primaryHub.new InternalSensor(881);
        sensor.printState();

        System.out.println("---------------------------------------------------------");
    }
}