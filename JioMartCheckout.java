public class JioMartCheckout {

    public static void main(String[] args) {
        System.out.println("=== JioMart Unified Payment Gateway ===");
        System.out.println("---------------------------------------");

        processPayment(1500);

        processPayment(2000, 150.50);

        processPayment(4500.75, "HDFC_PLATINUM");
    }

    public static void processPayment(int rawAmount) {
        System.out.println("Mode: CASH");
        System.out.println(" -> Settling exact amount of: " + rawAmount);
        System.out.println(" -> Receipt Generated. Status: settled.\n");
    }

    public static void processPayment(int baseAmount, double voucherDiscount) {
        double finalizedAmount = baseAmount - voucherDiscount;
        System.out.println("Mode: DIGITAL VOUCHER WALLET");
        System.out.println(" -> Base Amount : " + baseAmount);
        System.out.println(" -> Voucher Cut : " + voucherDiscount);
        System.out.println(" -> Final Debit : " + finalizedAmount);
        System.out.println(" -> Token Dispatched. Status: settled.\n");
    }

    public static void processPayment(double corporateAmount, String cardVendor) {
        final double MERCHANT_SURCHARGE = 25.00;
        double totalSettled = corporateAmount + MERCHANT_SURCHARGE;

        System.out.println("Mode: CORPORATE CREDIT CARD");
        System.out.println(" -> Card Network: " + cardVendor);
        System.out.println(" -> Core Charge : " + corporateAmount);
        System.out.println(" -> Surcharge   : " + MERCHANT_SURCHARGE);
        System.out.println(" -> Net Cleared : " + totalSettled);
        System.out.println(" -> Authorization Success. Status: settled.\n");
    }
}