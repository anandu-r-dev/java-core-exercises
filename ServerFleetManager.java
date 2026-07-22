import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ServerNod implements Comparable<ServerNod> {
    private final String nodeId;
    private final double cpuLoad;
    private final int memoryUsage;

    public ServerNod(String nodeId, double cpuLoad, int memoryUsage) {
        this.nodeId = nodeId;
        this.cpuLoad = cpuLoad;
        this.memoryUsage = memoryUsage;
    }

    public String getNodeId() {
        return nodeId;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }

    public int getMemoryUsage() {
        return memoryUsage;
    }

    @Override
    public int compareTo(ServerNod other) {
        return this.nodeId.compareTo(other.nodeId);
    }

    @Override
    public String toString() {
        return String.format("[%s | CPU: %.1f%% | RAM: %dMB]", nodeId, cpuLoad, memoryUsage);
    }
}

public class ServerFleetManager {

    public static void main(String[] args) {
        System.out.println("Initializing Cloud Fleet Sorting Workspace...");
        System.out.println("---------------------------------------------------------");

        List<ServerNod> fleet = new ArrayList<>();
        fleet.add(new ServerNod("Node-Gamma", 88.5, 4096));
        fleet.add(new ServerNod("Node-Alpha", 12.3, 8192));
        fleet.add(new ServerNod("Node-Beta", 45.0, 2048));

        Collections.sort(fleet);

        System.out.println("1. Natural Order (Sorted by Node ID alphabetically):");
        fleet.forEach(node -> System.out.println("   " + node));
        System.out.println("---------------------------------------------------------");

        Comparator<ServerNod> cpuLoadComparator = Comparator.comparingDouble(ServerNod::getCpuLoad);
        fleet.sort(cpuLoadComparator);

        System.out.println("2. Custom Order (Sorted by CPU Load ascending):");
        fleet.forEach(node -> System.out.println("   " + node));
        System.out.println("---------------------------------------------------------");


        Comparator<ServerNod> ramDescendingComparator = Comparator
                .comparingInt(ServerNod::getMemoryUsage)
                .reversed();

        fleet.sort(ramDescendingComparator);

        System.out.println("3. Custom Order (Sorted by RAM Usage descending):");
        fleet.forEach(node -> System.out.println("   " + node));
        System.out.println("---------------------------------------------------------");
    }
}