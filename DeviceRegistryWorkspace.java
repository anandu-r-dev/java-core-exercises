class NetworkSensor {
    private final String serialCode;
    private final int firmwareVersion;

    public NetworkSensor(String serialCode, int firmwareVersion) {
        this.serialCode = (serialCode != null) ? serialCode.trim() : "";
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        NetworkSensor other = (NetworkSensor) obj;

        return this.firmwareVersion == other.firmwareVersion &&
                this.serialCode.equals(other.serialCode);
    }
}

public class DeviceRegistryWorkspace {

    public static void main(String[] args) {
        System.out.println("Initializing Identity vs Equality Matrix Testing...");
        System.out.println("-------------------------------------------------------");

        NetworkSensor alphaSensor = new NetworkSensor("SN-909-X", 2);
        NetworkSensor betaSensor = new NetworkSensor("SN-909-X", 2);

        NetworkSensor referenceCopy = alphaSensor;

        System.out.println("Identity Comparison Results (==):");
        System.out.println(" -> alphaSensor == betaSensor    : " + (alphaSensor == betaSensor));
        System.out.println(" -> alphaSensor == referenceCopy : " + (alphaSensor == referenceCopy));

        System.out.println("-------------------------------------------------------");

        System.out.println("Logical Equivalence Results (.equals()):");
        System.out.println(" -> alphaSensor.equals(betaSensor)   : " + alphaSensor.equals(betaSensor));
        System.out.println(" -> alphaSensor.equals(referenceCopy): " + alphaSensor.equals(referenceCopy));
    }
}