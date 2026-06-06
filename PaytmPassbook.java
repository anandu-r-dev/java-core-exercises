public class PaytmPassbook {

    public static void main(String[] args) {
        int walletBalance = 4500;
        final int MONTHLY_SUBSCRIPTION_FEE = 600;
        int activeMonthCount = 0;

        System.out.println("Initial Wallet Balance: " + walletBalance);
        System.out.println("----------------------------------------");

        while (walletBalance >= MONTHLY_SUBSCRIPTION_FEE) {
            activeMonthCount++;
            walletBalance -= MONTHLY_SUBSCRIPTION_FEE;

            System.out.println("Month " + activeMonthCount + ": Deducted ₹"
                    + MONTHLY_SUBSCRIPTION_FEE + " | Remaining Balance: " + walletBalance);
        }

        System.out.println("----------------------------------------");
        System.out.println("Subscription Stopped: Insufficient funds for next month.");
        System.out.println("Total Months Maintained: " + activeMonthCount);
        System.out.println("Please Recharge. Current Balance: " + walletBalance);
    }
}