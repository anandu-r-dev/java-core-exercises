public class ZomatoDriverPayout {

    public static void main(String[] args) {
        String driverName = "Rajesh Kumar";
        int baseTripsPay = 14500;
        int surgeBonus = 2500;

        int finalizedPay = calculateNetEarnings(baseTripsPay, surgeBonus);

        printPayoutReceipt(driverName, finalizedPay);
    }

    public static int calculateNetEarnings(int basePay, int incentiveBonus) {
        final int PROFESSIONAL_TAX_DEDUCTION = 200;

        int grossEarnings = basePay + incentiveBonus;
        int netEarnings = grossEarnings - PROFESSIONAL_TAX_DEDUCTION;

        return netEarnings;
    }

    public static void printPayoutReceipt(String employeeName, int finalAmount) {
        System.out.println("=== BHARAT LOGISTICS PAYROLL TERMINAL ===");
        System.out.println("Contractor Name: " + employeeName);
        System.out.println("Net Disbursed  : ₹" + finalAmount);
        System.out.println("Status         : PROCESSED & CREDITED TO BANK");
        System.out.println("=========================================");
    }
}