import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SecurityLogAnalyzer {

    public static void main(String[] args) {
        System.out.println("Initializing High-Throughput Log Filter Pipeline...");
        System.out.println("---------------------------------------------------------");

        String[] rawIpLogStream = {
                "10.0.0.5", "192.168.1.100", "10.0.0.5", "172.16.0.1", "192.168.1.100"
        };

        Set<String> uniqueIpBuckets = new HashSet<>();

        for (String ip : rawIpLogStream) {
            boolean isAdded = uniqueIpBuckets.add(ip);
            if (!isAdded) {
                System.out.println("HashSet -> Dropped duplicate packet footprint: " + ip);
            }
        }

        System.out.print("HashSet Final Output (Unordered): ");
        System.out.println(uniqueIpBuckets);
        System.out.println("---------------------------------------------------------");

        Set<String> sortedIpTree = new TreeSet<>();

        for (String ip : rawIpLogStream) {
            sortedIpTree.add(ip);
        }

        System.out.print("TreeSet Final Output (Natural Ascending Order): ");
        System.out.println(sortedIpTree);
        System.out.println("---------------------------------------------------------");
    }
}