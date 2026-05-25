import java.util.concurrent.atomic.AtomicInteger;

public class CircuitBreakerChallenge {

    enum State { CLOSED, OPEN }

    public static class CircuitBreaker {
        private State state = State.CLOSED;
        private final int failureThreshold;
        private final long cooldownPeriodMillis;

        private final AtomicInteger failureCount = new AtomicInteger(0);
        private long lastFailureTime = 0;

        public CircuitBreaker(int failureThreshold, long cooldownPeriodMillis) {
            this.failureThreshold = failureThreshold;
            this.cooldownPeriodMillis = cooldownPeriodMillis;
        }

        public String execute(java.util.function.Supplier<String> externalCall, String fallbackResponse) {
            if (state == State.OPEN) {
                if (System.currentTimeMillis() - lastFailureTime > cooldownPeriodMillis) {
                    System.out.println("[Circuit] Cooldown passed. Attempting a canary request (Closing Circuit)...");
                    reset();
                } else {
                    System.out.println("[Circuit] *OPEN* - Fast-failing request. Returning fallback.");
                    return fallbackResponse;
                }
            }

            try {
                String response = externalCall.get();
                if (state == State.CLOSED) failureCount.set(0);
                return response;
            } catch (Exception e) {
                handleFailure();
                return fallbackResponse;
            }
        }

        private void handleFailure() {
            lastFailureTime = System.currentTimeMillis();
            int currentFailures = failureCount.incrementAndGet();
            System.out.println("[Circuit] Call failed. Current failure streak: " + currentFailures);

            if (currentFailures >= failureThreshold) {
                this.state = State.OPEN;
                System.out.println("!!! ALERT: Failure threshold reached. CIRCUIT IS NOW OPEN !!!");
            }
        }

        private void reset() {
            this.state = State.CLOSED;
            this.failureCount.set(0);
        }
    }

    public static void main(String[] args) {
        CircuitBreaker breaker = new CircuitBreaker(2, 2000);

        java.util.function.Supplier<String> mockHealthyApi = () -> "Payment Status: SUCCESS";
        java.util.function.Supplier<String> mockCrashedApi = () -> { throw new RuntimeException("Timeout!"); };

        System.out.println("--- 1. Testing Healthy External Dependency ---");
        System.out.println("Result: " + breaker.execute(mockHealthyApi, "Gateway Down Fallback"));

        System.out.println("\n--- 2. Inducing Failures ---");
        System.out.println("Result: " + breaker.execute(mockCrashedApi, "Gateway Down Fallback")); // Failure 1
        System.out.println("Result: " + breaker.execute(mockCrashedApi, "Gateway Down Fallback")); // Failure 2 -> Opens Circuit

        System.out.println("\n--- 3. Testing While Circuit Is Open ---");
        System.out.println("Result: " + breaker.execute(mockHealthyApi, "Gateway Down Fallback"));

        System.out.println("\n--- 4. Simulating Waiting for Cooldown Window ---");
        try { Thread.sleep(2100); } catch (InterruptedException ignored) {}

        System.out.println("Result: " + breaker.execute(mockHealthyApi, "Gateway Down Fallback")); // Recovers!
    }
}