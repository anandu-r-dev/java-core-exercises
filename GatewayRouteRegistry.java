import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GatewayRouteRegistry {

    public static void main(String[] args) {
        System.out.println("Initializing High-Speed Key-Value Routing Matrices...");
        System.out.println("---------------------------------------------------------");

        Map<String, Integer> activeRoutingTable = new HashMap<>();

        activeRoutingTable.put("payment-service", 8082);
        activeRoutingTable.put("auth-service", 8081);
        activeRoutingTable.put("inventory-service", 8083);

        activeRoutingTable.put("auth-service", 9000);

        System.out.println("HashMap Content (Order depends on hash buckets):");
        for (Map.Entry<String, Integer> route : activeRoutingTable.entrySet()) {
            System.out.println(" -> Service Key: " + route.getKey() + " maps to Port: " + route.getValue());
        }

        System.out.println(" -> Direct Query [auth-service]: Active Port is " + activeRoutingTable.get("auth-service"));
        System.out.println("---------------------------------------------------------");

        Map<String, Integer> sortedRoutingTable = new TreeMap<>();

        sortedRoutingTable.put("payment-service", 8082);
        sortedRoutingTable.put("auth-service", 8081);
        sortedRoutingTable.put("inventory-service", 8083);

        System.out.println("TreeMap Content (Sorted alphabetically by key names):");
        for (Map.Entry<String, Integer> route : sortedRoutingTable.entrySet()) {
            System.out.println(" -> Service Key: " + route.getKey() + " maps to Port: " + route.getValue());
        }
        System.out.println("---------------------------------------------------------");
    }
}