class WarehouseNode {
    int nodeId;
    String locationCode;
    int availablePallets;

    public void printNodeDetails() {
        System.out.println("Warehouse Node ID : " + nodeId);
        System.out.println("Location Identifier: " + locationCode);
        System.out.println("Available Pallets  : " + availablePallets + " slots");
        System.out.println("----------------------------------------");
    }
}

public class LogisticsNodeManager {

    public static void main(String[] args) {
        System.out.println("Initializing Logistics Node Architecture...");
        System.out.println("----------------------------------------");

        WarehouseNode southNode = new WarehouseNode();

        southNode.nodeId = 1001;
        southNode.locationCode = "MUM-SOUTH-01";
        southNode.availablePallets = 450;

        WarehouseNode northNode = new WarehouseNode();

        northNode.nodeId = 1002;
        northNode.locationCode = "DEL-NORTH-02";
        northNode.availablePallets = 820;

        System.out.println("=== Inspecting South Node State ===");
        southNode.printNodeDetails();

        System.out.println("=== Inspecting North Node State ===");
        northNode.printNodeDetails();

        southNode.availablePallets = 500;

        System.out.println("=== Verification After South Node Modification ===");
        System.out.println("South Node New Pallets: " + southNode.availablePallets);
        System.out.println("North Node Old Pallets: " + northNode.availablePallets + " (Unchanged!)");
    }
}