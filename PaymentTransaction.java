public class PaymentTransaction {

    private String transactionId;
    private double amount;
    private String status;

    public PaymentTransaction(String transactionId, double amount, String status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }

    public void processPayment() {
        if (this.status.equals("PENDING")) {
            System.out.println("Processing transaction " + transactionId + " for ₹" + amount + "...");
            this.status = "SUCCESS";
        } else {
            System.out.println("Transaction " + transactionId + " is already " + status);
        }
    }

    public static void main(String[] args) {

        PaymentTransaction rentPayment = new PaymentTransaction("TXN-9981", 6000.0, "PENDING");
        PaymentTransaction chittiDeposit = new PaymentTransaction("TXN-9982", 10000.0, "SUCCESS");

        System.out.println("--- Spring Boot Payment Gateway ---");
        rentPayment.processPayment();
        chittiDeposit.processPayment();
    }
}