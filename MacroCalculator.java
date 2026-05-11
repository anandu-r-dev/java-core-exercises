import java.util.Scanner;

public class MacroCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Daily Protein Calculator ---");

        System.out.print("Enter your current body weight in kilograms (e.g., 80.5): ");
        double weight = scanner.nextDouble();

        System.out.println("\nSelect your current physical goal:");
        System.out.println("1. Maintenance");
        System.out.println("2. Bulking");
        System.out.println("3. Cutting / Body Recomposition");
        System.out.print("Enter the number of your choice (1, 2, or 3): ");
        int goal = scanner.nextInt();

        double proteinMultiplier = 0.0;
        String goalText = "";

        switch (goal) {
            case 1:
                proteinMultiplier = 1.6;
                goalText = "Maintenance";
                break;
            case 2:
                proteinMultiplier = 1.8;
                goalText = "Bulking";
                break;
            case 3:
                proteinMultiplier = 2.2;
                goalText = "Cutting / Body Recomposition";
                break;
            default:
                System.out.println("Invalid selection. Please restart the program and choose 1, 2, or 3.");
                scanner.close();
                return;
        }

        double dailyProtein = weight * proteinMultiplier;

        System.out.printf("\nAt a body weight of %.1f kg with a goal of '%s',%n", weight, goalText);
        System.out.printf("your daily protein target is: %.1f grams.%n", dailyProtein);

        scanner.close();
    }
}