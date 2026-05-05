public class ExpenseTrackerAPI {

    public @interface RestController {}
    public @interface Service {}
    public @interface RestControllerAdvice {}
    public @interface ExceptionHandler {}

    public static class BudgetExceededException extends RuntimeException {
        public BudgetExceededException(String message) { super(message); }
    }

    @RestControllerAdvice
    public static class GlobalExceptionHandler {
        @ExceptionHandler
        public void handleBudgetCrash(BudgetExceededException ex) {
            System.out.println("\n[SYSTEM ALERT] HTTP 403 Forbidden");
            System.out.println("{ error: '" + ex.getMessage() + "', action: 'Transaction Blocked' }\n");
        }
    }

    public record ExpenseRequest(String category, double amount) {}

    @Service
    public static class BudgetService {
        private final double DAILY_LIMIT = 500.0;
        private double currentDailySpend = 0.0;

        public void processTransaction(ExpenseRequest request) {
            System.out.println("[Service] Validating transaction: ₹" + request.amount() + " for " + request.category());

            if (currentDailySpend + request.amount() > DAILY_LIMIT) {
                throw new BudgetExceededException("Transaction rejected. Exceeds daily limit of ₹" + DAILY_LIMIT);
            }

            currentDailySpend += request.amount();
            System.out.println("[Database] Saved. Remaining daily budget: ₹" + (DAILY_LIMIT - currentDailySpend));
        }
    }

    @RestController
    public static class ExpenseController {
        private final BudgetService budgetService;

        public ExpenseController(BudgetService budgetService) {
            this.budgetService = budgetService;
        }

        public void handlePostRequest(ExpenseRequest payload) {
            System.out.println("-> [API] POST /api/v1/expenses | Payload: " + payload.category());
            budgetService.processTransaction(payload);
            System.out.println("<- [API] HTTP 201 Created\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Spring Boot Expense API Booting Up ---\n");

        BudgetService service = new BudgetService();
        ExpenseController controller = new ExpenseController(service);
        GlobalExceptionHandler errorHandler = new GlobalExceptionHandler();

        try {
            controller.handlePostRequest(new ExpenseRequest("Market Grocery", 350.0));

            controller.handlePostRequest(new ExpenseRequest("Restaurant Delivery", 250.0));

        } catch (BudgetExceededException ex) {
            errorHandler.handleBudgetCrash(ex);
        }
    }
}