public class LICPremiumLedger {

    public static void main(String[] args) {
        double[] premiumAccounts = {5000.0, 12500.0, 8200.0, 24000.0, 3100.0};

        final double GST_RATE_COEFFICIENT = 1.18;

        System.out.println("Processing LIC Premium Accounts Database...");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < premiumAccounts.length; i++) {
            premiumAccounts[i] = premiumAccounts[i] * GST_RATE_COEFFICIENT;
        }

        int accountCounter = 1;
        for (double finalizedPremium : premiumAccounts) {

            System.out.println("Policy Account #" + accountCounter + " | Post-GST Due: "
                    + String.format("%.2f", finalizedPremium));

            accountCounter++;

        }

        System.out.println("------------------------------------------------");
        System.out.println("Batch ledger update completed successfully.");
    }
}