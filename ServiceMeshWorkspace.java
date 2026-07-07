interface NodeService {

    void executeService();

    default void runHealthCheck() {
        System.out.println("NodeService Default Gate: Telemetry handshake successful. Node healthy.");
    }

    static String getFrameworkSignature() {
        return "ServiceMesh-Core-Engine v4.0.2";
    }
}

class ComputeContainer implements NodeService {
    private final String containerId;

    public ComputeContainer(String containerId) {
        this.containerId = containerId;
    }

    @Override
    public void executeService() {
        System.out.println("ComputeContainer [" + containerId + "]: Initializing virtualization sub-threads...");
    }
}

public class ServiceMeshWorkspace {

    public static void main(String[] args) {
        System.out.println("Booting Distributed Service Mesh Engine...");
        System.out.println("---------------------------------------------------------");

        String signature = NodeService.getFrameworkSignature();
        System.out.println("Framework Identity: " + signature);
        System.out.println("---------------------------------------------------------");

        NodeService activeContainer = new ComputeContainer("LX-POD-09");

        activeContainer.executeService();

        activeContainer.runHealthCheck();

        System.out.println("---------------------------------------------------------");
    }
}