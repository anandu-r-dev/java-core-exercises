public class BudgetServiceTest {
    public @interface Test {}

    public static class BudgetExceededException extends RuntimeException {
        public BudgetExceededException(String message) { super(message); }
    }

    public static class BudgetService {
        private final double DAILY_LIMIT = 500.0;
        private double currentDailySpend = 0.0;

        public void processTransaction(double amount) {
            if (currentDailySpend + amount > DAILY_LIMIT) {
                throw new BudgetExceededException("Limit Exceeded");
            }
            currentDailySpend += amount;
        }
    }

    @Test
    public static void testValidTransaction() {
        BudgetService service = new BudgetService();
        try {
            service.processTransaction(350.0);
            System.out.println("[PASS] Valid transaction processed successfully.");
        } catch (Exception e) {
            System.out.println("[FAIL] Valid transaction threw an unexpected error.");
        }
    }

    @Test
    public static void testTransactionBlocksWhenLimitExceeded() {
        BudgetService service = new BudgetService();
        try {
            service.processTransaction(600.0);

            System.out.println("[FAIL] System allowed a transaction over the ₹500 limit!");
        } catch (BudgetExceededException e) {
            System.out.println("[PASS] System correctly blocked the over-budget transaction.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Running JUnit Test Suite ---\n");
        testValidTransaction();
        testTransactionBlocksWhenLimitExceeded();
        System.out.println("\n--- Test Suite Completed ---");
    }
}