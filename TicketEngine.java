import java.util.Scanner;

public class TicketEngine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cinema Booking System ---");

        System.out.print("Enter number of tickets: ");
        int tickets = scanner.nextInt();

        System.out.print("Is it a weekend? (true/false): ");
        boolean isWeekend = scanner.nextBoolean();

        double basePrice = calculateBasePrice(tickets);

        double priceAfterSurcharge = applyWeekendSurcharge(basePrice, isWeekend);

        double finalPrice = calculateTax(priceAfterSurcharge);

        System.out.println("\n--- Final Receipt ---");
        System.out.printf("Base Price: ₹%.2f%n", basePrice);
        System.out.printf("After Surcharge: ₹%.2f%n", priceAfterSurcharge);
        System.out.printf("Grand Total (inc. 18%% GST): ₹%.2f%n", finalPrice);

        scanner.close();
    }

    public static double calculateBasePrice(int numberOfTickets) {
        return numberOfTickets * 200.0;
    }

    public static double applyWeekendSurcharge(double currentPrice, boolean isWeekend) {
        if (isWeekend) {
            return currentPrice * 1.15;
        }
        return currentPrice;
    }

    public static double calculateTax(double priceBeforeTax) {
        return priceBeforeTax * 1.18;
    }
}