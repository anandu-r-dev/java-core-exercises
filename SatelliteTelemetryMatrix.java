
public class SatelliteTelemetryMatrix {

    public static void main(String[] args) {
        byte activePayloads = 12;
        short coreTemperatureKelvin = -14_850;
        int orbitalVelocityKmh = 27_580;
        long uptimeMilliseconds = 14_982_304_851L;
        float orbitalStabilityIndex = 0.99842f;
        double fuelPercentageCoefficient = 87.49201384;
        char transmissionSector = 'G';
        boolean systemIsOperational = true;

        System.out.println("==================================================");
        System.out.println("          SATELLITE TELEMETRY MATRIX REPORT       ");
        System.out.println("==================================================");
        System.out.println("Payload Configuration Count : " + activePayloads + " units [byte]");
        System.out.println("Core Structural Temperature : " + coreTemperatureKelvin + " mK [short]");
        System.out.println("Current Cruise Velocity     : " + orbitalVelocityKmh + " km/h [int]");
        System.out.println("Accumulated System Uptime   : " + uptimeMilliseconds + " ms [long]");
        System.out.println("Stability Trajectory Index  : " + orbitalStabilityIndex + " [float]");
        System.out.println("Fuel Volumetric Coefficient : " + fuelPercentageCoefficient + "% [double]");
        System.out.println("Transmission Sector Target  : Sector " + transmissionSector + " [char]");
        System.out.println("Master System Health State  : ONLINE (" + systemIsOperational + ") [boolean]");
        System.out.println("==================================================");
    }
}