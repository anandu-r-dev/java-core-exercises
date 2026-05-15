import java.util.InputMismatchException;
import java.util.Scanner;

public class BillSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- The Bulletproof Bill Splitter ---");

        try {
            System.out.print("Enter the total bill amount: ₹");
            double totalBill = scanner.nextDouble();

            System.out.print("Enter the number of people: ");
            int numberOfPeople = scanner.nextInt();

            if (numberOfPeople <= 0) {
                throw new ArithmeticException("You cannot split a bill with zero or negative people.");
            }

            double amountPerPerson = totalBill / numberOfPeople;
            System.out.printf("Each person needs to pay: ₹%.2f%n", amountPerPerson);

        }
        catch (InputMismatchException e) {
            System.out.println("\n❌ CRASH PREVENTED: Invalid input! You must enter numbers, not text.");
        }
        catch (ArithmeticException e) {
            System.out.println("\n❌ CRASH PREVENTED: Math Error - " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("\n❌ CRASH PREVENTED: An unknown system error occurred.");
        }
        finally {
            System.out.println("\n[System Info: Cleaning up memory and closing scanner...]");
            scanner.close();
            System.out.println("--- Application Terminated Safely ---");
        }
    }
}