public class TransactionProcessor {

    public static final double PROCESSING_FEE_RATE = 0.025;
    public static final double MAX_TRANSFER_LIMIT = 1_000_000.00;

    public static void main(String[] args) {
        double requestAmount = 250_000.00;

        System.out.println("Initializing Transaction Architecture...");
        System.out.println("Configured System Fee Rate : " + (PROCESSING_FEE_RATE * 100) + "%");
        System.out.println("Configured Max Limit       : $" + MAX_TRANSFER_LIMIT);
        System.out.println("--------------------------------------------------");

        double calculatedFee;
        double finalSettlement;

        if (requestAmount <= MAX_TRANSFER_LIMIT) {
            String statusMessage = "Transaction within safe operational bounds.";
            System.out.println("Status: " + statusMessage);
            calculatedFee = requestAmount * PROCESSING_FEE_RATE;
            finalSettlement = requestAmount + calculatedFee;

        } else {
            System.out.println("Status: CRITICAL - Limit Exceeded.");
            calculatedFee = 0.0;
            finalSettlement = 0.0;
        }
        System.out.println("Requested Amount           : $" + requestAmount);
        System.out.println("Assessed Processing Fee    : $" + calculatedFee);
        System.out.println("Total Settlement Amount    : $" + finalSettlement);
        System.out.println("--------------------------------------------------");

    }
}