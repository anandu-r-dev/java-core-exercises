public class SpringDataJpaPractice {

    public @interface Entity {}
    public @interface Id {}

    @Entity
    public static class FinancialTransaction {
        @Id
        private String transactionId;
        private double amount;
        private String type;

        public FinancialTransaction(String transactionId, double amount, String type) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.type = type;
        }

        public double getAmount() { return amount; }
        public String getType() { return type; }
    }

    public interface TransactionRepository {
        void save(FinancialTransaction transaction);
        double calculateRemainingCapital();
    }

    public static class PostgresDatabaseSimulator implements TransactionRepository {
        private double ledgerBalance = 0;

        @Override
        public void save(FinancialTransaction txn) {
            System.out.println("[Hibernate/JPA] Executing: INSERT INTO transactions VALUES ('" + txn.type + "', " + txn.getAmount() + ")");
            if (txn.getType().equals("INCOME")) {
                ledgerBalance += txn.getAmount();
            } else {
                ledgerBalance -= txn.getAmount();
            }
        }

        @Override
        public double calculateRemainingCapital() {
            return ledgerBalance;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Booting Spring Data JPA Module ---\n");
        TransactionRepository database = new PostgresDatabaseSimulator();

        System.out.println("Event: May 4th Salary Deposit");
        database.save(new FinancialTransaction("TXN-001", 29800.0, "INCOME"));

        System.out.println("\nEvent: Executing Fixed Deductions");
        database.save(new FinancialTransaction("TXN-002", 10000.0, "EXPENSE")); // KSFE
        database.save(new FinancialTransaction("TXN-003", 6000.0, "EXPENSE"));  // Rent

        System.out.println("\n[API Response] Remaining Operational Capital: ₹" + database.calculateRemainingCapital());
    }
}