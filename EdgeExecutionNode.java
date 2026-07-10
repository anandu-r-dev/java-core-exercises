interface TaskWorker {
    void executePayload();
}

class EdgeExecutionNode {

    private final String nodeLocation = "EDGE-CLUSTER-05";

    public void processWithLocalClass() {
        String executionToken = "TOKEN-99X";

        class AuditedWorker implements TaskWorker {
            @Override
            public void executePayload() {
                System.out.println("Local Class -> Node Anchor : " + nodeLocation);
                System.out.println("Local Class -> Processing Payload with: " + executionToken);
            }
        }

        AuditedWorker worker = new AuditedWorker();
        worker.executePayload();

    }

    public void processWithAnonymousClass() {
        System.out.println("Preparing Anonymous Execution Block...");

        TaskWorker anonymousWorker = new TaskWorker() {
            private final long timestamp = System.currentTimeMillis();

            @Override
            public void executePayload() {
                System.out.println("Anonymous Class -> Direct event handling sequence triggered.");
                System.out.println("Anonymous Class -> System Temporal Marker: " + timestamp + " ms");
            }
        };

        anonymousWorker.executePayload();
    }

    public static void main(String[] args) {
        System.out.println("Starting Edge Computing Local Class Sandbox...");
        System.out.println("---------------------------------------------------------");

        EdgeExecutionNode engine = new EdgeExecutionNode();

        engine.processWithLocalClass();

        System.out.println("---------------------------------------------------------");

        engine.processWithAnonymousClass();

        System.out.println("---------------------------------------------------------");
    }
}