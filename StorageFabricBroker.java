import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StorageFabricBroker {

    public static void evaluateListContract(String listTypeIdentifier, List<String> operationalBuffer) {
        System.out.println("Executing Operations against: " + listTypeIdentifier);

        operationalBuffer.add("TX-BLOCK-01");
        operationalBuffer.add("TX-BLOCK-02");
        operationalBuffer.add("TX-BLOCK-03");

        operationalBuffer.add("TX-BLOCK-01");

        operationalBuffer.add(1, "TX-PRIORITY-NODE");

        String targetedElement = operationalBuffer.get(2);
        System.out.println(" -> Element located at Index [2]: " + targetedElement);

        System.out.print(" -> Unified Content Enumeration: ");
        for (String record : operationalBuffer) {
            System.out.print("[" + record + "] ");
        }
        System.out.println("\n---------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("Initializing Java List Framework Comparison Engine...");
        System.out.println("---------------------------------------------------------");

        List<String> dynamicArrayPool = new ArrayList<>();
        evaluateListContract("ArrayList Engine (Contiguous Allocation)", dynamicArrayPool);

        List<String> doubleLinkedNodePool = new LinkedList<>();
        evaluateListContract("LinkedList Engine (Node Pointer Chain)", doubleLinkedNodePool);
    }
}