public class ParkingRateCalculator {

    public static void main(String[] args) {
        boolean isPeakHour = true;
        double baseRate = 20.0;
        double peakSurcharge = 15.0;

        double finalBill = isPeakHour ? (baseRate + peakSurcharge) : baseRate;

        String pricingStatus = isPeakHour ? "PEAK RATE APPLIED" : "STANDARD RATE";

        System.out.println("--- Garage Receipt ---");
        System.out.println("Status   : " + pricingStatus);
        System.out.println("Total Due: " + finalBill);
    }
}