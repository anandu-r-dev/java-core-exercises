class UtilityAsset {
    protected String assetId;

    public UtilityAsset(String assetId) {
        this.assetId = assetId;
    }

    public void logStatus() {
        System.out.println("Asset [" + assetId + "]: Online and reporting telemetry.");
    }
}

class WaterPipeline extends UtilityAsset {
    private final int pressurePsi;

    public WaterPipeline(String assetId, int pressurePsi) {
        super(assetId);
        this.pressurePsi = pressurePsi;
    }

    public void checkPressurePsi() {
        System.out.println(" -> Telemetry: Fluid Pressure stands at " + pressurePsi + " PSI.");
    }
}

class SolarInverter extends UtilityAsset {
    private final double gridYieldKn;

    public SolarInverter(String assetId, double gridYieldKn) {
        super(assetId);
        this.gridYieldKn = gridYieldKn;
    }

    public void calculateGridYieldKn() {
        System.out.println(" -> Telemetry: Daily Solar Inverter output: " + gridYieldKn + " KN.");
    }
}

public class GridAutomationSystem {

    public static void main(String[] args) {
        System.out.println("Booting Smart Grid Sensor Array Systems...");
        System.out.println("------------------------------------------------");

        UtilityAsset[] assetInventory = new UtilityAsset[2];
        assetInventory[0] = new WaterPipeline("WP-ZONE-01", 65);
        assetInventory[1] = new SolarInverter("SL-NODE-99", 420.75);

        for (UtilityAsset currentAsset : assetInventory) {
            currentAsset.logStatus();

            if (currentAsset instanceof WaterPipeline pipeline) {
                pipeline.checkPressurePsi();
            }
            else if (currentAsset instanceof SolarInverter inverter) {
                inverter.calculateGridYieldKn();
            }

            System.out.println("------------------------------------------------");
        }
    }
}